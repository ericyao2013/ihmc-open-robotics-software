package us.ihmc.darpaRoboticsChallenge.networkProcessor;

import java.io.IOException;
import java.net.URI;

import us.ihmc.SdfLoader.SDFFullRobotModel;
import us.ihmc.darpaRoboticsChallenge.DRCConfigParameters;
import us.ihmc.darpaRoboticsChallenge.DRCLocalConfigParameters;
import us.ihmc.darpaRoboticsChallenge.configuration.DRCNetClassList;
import us.ihmc.darpaRoboticsChallenge.drcRobot.DRCRobotDataReceiver;
import us.ihmc.darpaRoboticsChallenge.drcRobot.DRCRobotModel;
import us.ihmc.darpaRoboticsChallenge.drcRobot.DRCRobotSensorInformation;
import us.ihmc.darpaRoboticsChallenge.drcRobot.DRCSensorParameters;
import us.ihmc.darpaRoboticsChallenge.handControl.packetsAndConsumers.HandJointAnglePacket;
import us.ihmc.darpaRoboticsChallenge.networkProcessor.camera.CameraInfoReceiver;
import us.ihmc.darpaRoboticsChallenge.networkProcessor.camera.FishEyeDataReceiver;
import us.ihmc.darpaRoboticsChallenge.networkProcessor.camera.RosCameraReceiver;
import us.ihmc.darpaRoboticsChallenge.networkProcessor.camera.MultiSenseCameraInfoReciever;
import us.ihmc.darpaRoboticsChallenge.networkProcessor.camera.SCSCameraDataReceiver;
import us.ihmc.darpaRoboticsChallenge.networkProcessor.lidar.GazeboLidarDataReceiver;
import us.ihmc.darpaRoboticsChallenge.networkProcessor.lidar.RobotBoundingBoxes;
import us.ihmc.darpaRoboticsChallenge.networkProcessor.lidar.SCSLidarDataReceiver;
import us.ihmc.darpaRoboticsChallenge.networkProcessor.ros.RosNativeNetworkProcessor;
import us.ihmc.darpaRoboticsChallenge.networkProcessor.state.RobotPoseBuffer;
import us.ihmc.darpaRoboticsChallenge.networkProcessor.time.PPSTimestampOffsetProvider;
import us.ihmc.darpaRoboticsChallenge.networking.DRCNetworkProcessorNetworkingManager;
import us.ihmc.darpaRoboticsChallenge.networking.dataProducers.DRCJointConfigurationData;
import us.ihmc.graphics3DAdapter.camera.VideoSettings;
import us.ihmc.utilities.net.AtomicSettableTimestampProvider;
import us.ihmc.utilities.net.KryoObjectClient;
import us.ihmc.utilities.net.LocalObjectCommunicator;
import us.ihmc.utilities.net.ObjectCommunicator;
import us.ihmc.utilities.net.ObjectConsumer;
import us.ihmc.utilities.ros.RosMainNode;

public class DRCNetworkProcessor
{
   private final VideoSettings videoSettings;

   private final ObjectCommunicator fieldComputerClient;
   private final AtomicSettableTimestampProvider timestampProvider = new AtomicSettableTimestampProvider();
   private final DRCNetworkProcessorNetworkingManager networkingManager;
   private final RobotPoseBuffer robotPoseBuffer;
   private final DRCRobotSensorInformation sensorInformation;

   private final PPSTimestampOffsetProvider ppsTimestampOffsetProvider;

   private final SDFFullRobotModel fullRobotModel;
   private final RobotBoundingBoxes robotBoundingBoxes;

   private static String scsMachineIPAddress = DRCLocalConfigParameters.ROBOT_CONTROLLER_IP_ADDRESS;
   /*
    * This will become a stand-alone application in the final competition. Do
    * NOT pass in objects shared with the DRC simulation!
    */
   public DRCNetworkProcessor(URI rosCoreURI, DRCRobotModel robotModel)
   {
      this(rosCoreURI, null, robotModel);
   }

   public DRCNetworkProcessor(URI rosCoreURI, ObjectCommunicator drcNetworkObjectCommunicator, DRCRobotModel robotModel)
   {
      this(drcNetworkObjectCommunicator, robotModel);

      System.out.println("Connecting to ROS");

      if(DRCLocalConfigParameters.ENABLE_CAMERA_AND_LIDAR)
      {
         RosMainNode rosMainNode;
         rosMainNode = new RosMainNode(rosCoreURI, "darpaRoboticsChallange/networkProcessor");
         
         RosNativeNetworkProcessor rosNativeNetworkProcessor;
         if (RosNativeNetworkProcessor.hasNativeLibrary())
         {
            rosNativeNetworkProcessor = RosNativeNetworkProcessor.getInstance(rosCoreURI.toString());
            rosNativeNetworkProcessor.connect();
         }
         else
         {
            rosNativeNetworkProcessor = null;
         }
         RosCameraReceiver cameraReceiver = new RosCameraReceiver(sensorInformation.getPrimaryCameraParamaters(), robotPoseBuffer, videoSettings, rosMainNode, networkingManager,ppsTimestampOffsetProvider);
//         CameraInfoReceiver cameraInfoServer = new MultiSenseCameraInfoReciever(rosMainNode, networkingManager.getControllerStateHandler());
//         networkingManager.getControllerCommandHandler().setIntrinsicServer(cameraInfoServer);
         
         new GazeboLidarDataReceiver(rosMainNode, robotPoseBuffer, networkingManager, fullRobotModel, robotBoundingBoxes,
               robotModel.getSensorInformation(), fieldComputerClient, rosNativeNetworkProcessor, ppsTimestampOffsetProvider);
         
//         new FishEyeDataReceiver(robotPoseBuffer, videoSettings, rosMainNode, networkingManager, DRCSensorParameters.DEFAULT_FIELD_OF_VIEW, ppsTimestampOffsetProvider);
         
         ppsTimestampOffsetProvider.attachToRosMainNode(rosMainNode);
         
         
         rosMainNode.execute();
         
         if(DRCConfigParameters.CALIBRATE_ARM_MODE)
         {
            new ArmCalibrationHelper(fieldComputerClient, networkingManager, cameraReceiver,robotModel.getJointMap());
         }
      }
      else
      {
         System.err.println("WARNING: DRCLocalConfigParameters: Camera and LIDAR disabled.");
      }


      //      if (DRCConfigParameters.USE_DUMMY_DRIVNG)
      //      {
      //         DrivingProcessorFactory.createCheatingDrivingProcessor(networkingManager, cameraDataReceiver, timestampProvider, rosCoreURI.toString(),
      //                 transformForDrivingProviderListener);
      //      }
      //      else
      //      {
      //         DrivingProcessorFactory.createDrivingProcessor(networkingManager, cameraDataReceiver, timestampProvider, fieldComputerClient,
      //                 transformForDrivingProviderListener);
      //      }
      
      connect();
   }

   public DRCNetworkProcessor(LocalObjectCommunicator scsCommunicator, ObjectCommunicator drcNetworkObjectCommunicator, DRCRobotModel robotModel)
   {
      this(drcNetworkObjectCommunicator, robotModel);
      SCSCameraDataReceiver cameraReceiver = new SCSCameraDataReceiver(robotPoseBuffer, videoSettings, scsCommunicator, networkingManager,
            ppsTimestampOffsetProvider);
      new SCSLidarDataReceiver(robotPoseBuffer, scsCommunicator, networkingManager, fullRobotModel, robotBoundingBoxes, robotModel.getSensorInformation(), fieldComputerClient,
            ppsTimestampOffsetProvider);
      
      if(DRCConfigParameters.CALIBRATE_ARM_MODE)
      {
         new ArmCalibrationHelper(fieldComputerClient, networkingManager, cameraReceiver,robotModel.getJointMap());
      }
      
      connect();

   }

   private DRCNetworkProcessor(ObjectCommunicator fieldComputerClientL, DRCRobotModel robotModel)
   {
      if (fieldComputerClientL == null)
      {
         this.fieldComputerClient = new KryoObjectClient(scsMachineIPAddress, DRCConfigParameters.NETWORK_PROCESSOR_TO_CONTROLLER_TCP_PORT,
               new DRCNetClassList());
         ((KryoObjectClient) this.fieldComputerClient).setReconnectAutomatically(true);
      }
      else
      {
         this.fieldComputerClient = fieldComputerClientL;
      }

      robotPoseBuffer = new RobotPoseBuffer(this.fieldComputerClient, 1000, timestampProvider);
      networkingManager = new DRCNetworkProcessorNetworkingManager(this.fieldComputerClient, timestampProvider, robotModel);

      fullRobotModel = robotModel.createFullRobotModel();
      
      DRCRobotDataReceiver drcRobotDataReceiver = new DRCRobotDataReceiver(robotModel, fullRobotModel);
      this.fieldComputerClient.attachListener(DRCJointConfigurationData.class, drcRobotDataReceiver);
      robotBoundingBoxes = new RobotBoundingBoxes(drcRobotDataReceiver, fullRobotModel, robotModel);

      this.fieldComputerClient.attachListener(HandJointAnglePacket.class,new ObjectConsumer<HandJointAnglePacket>()
      {
         @Override
         public void consumeObject(HandJointAnglePacket object)
         {
            networkingManager.getControllerStateHandler().sendHandJointAnglePacket(object); }
      });
      
      sensorInformation = robotModel.getSensorInformation();
      ppsTimestampOffsetProvider = robotModel.getPPSTimestampOffsetProvider();
      videoSettings = sensorInformation.getPrimaryCameraParamaters().getVideoSettings();
   }

   private void connect()
   {
      try
      {
         this.fieldComputerClient.connect();
      }
      catch (IOException e)
      {
         throw new RuntimeException(e);
      }
      networkingManager.connect();
   }

   
}
