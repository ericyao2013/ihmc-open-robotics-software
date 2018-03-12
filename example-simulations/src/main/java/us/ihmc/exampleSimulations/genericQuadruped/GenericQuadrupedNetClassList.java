package us.ihmc.exampleSimulations.genericQuadruped;

import us.ihmc.communication.packets.Packet;
import us.ihmc.euclid.tuple2D.Point2D32;
import us.ihmc.euclid.tuple3D.Point3D;
import us.ihmc.euclid.tuple3D.Vector3D;
import us.ihmc.euclid.tuple4D.Quaternion;
import us.ihmc.humanoidRobotics.kryo.IHMCCommunicationKryoNetClassList;
import us.ihmc.quadrupedRobotics.communication.packets.*;
import us.ihmc.quadrupedRobotics.controller.force.QuadrupedForceControllerEnum;
import us.ihmc.quadrupedRobotics.controller.force.QuadrupedForceControllerRequestedEvent;
import us.ihmc.quadrupedRobotics.planning.QuadrupedTimedStep;
import us.ihmc.quadrupedRobotics.planning.QuadrupedXGaitSettings;
import us.ihmc.quadrupedRobotics.util.TimeInterval;
import us.ihmc.robotics.partNames.QuadrupedJointName;
import us.ihmc.robotics.robotSide.RobotQuadrant;

import java.util.ArrayList;

public class GenericQuadrupedNetClassList extends IHMCCommunicationKryoNetClassList
{
   public GenericQuadrupedNetClassList()
   {
      super();
      registerPacketClass(Packet.class);

      registerPacketClass(QuadrupedNeckJointPositionPacket.class);
      registerPacketField(QuadrupedJointName.class);
      registerPacketField(QuadrupedJointName[].class);
      registerPacketField(double[].class);

      registerPacketClass(QuadrupedTimedStepPacket.class);
      registerPacketField(ArrayList.class);
      registerPacketField(QuadrupedTimedStep.class);

      registerPacketField(Point2D32.class);

      registerPacketField(String[].class);
      registerPacketField(Point3D[].class);

      registerPacketClass(ComPositionPacket.class);
      registerPacketField(Point3D.class);

      registerPacketClass(ComVelocityPacket.class);
      registerPacketField(Vector3D.class);

      registerPacketClass(BodyOrientationPacket.class);
      registerPacketField(Quaternion.class);

      registerPacketClass(BodyAngularRatePacket.class);
      registerPacketField(Vector3D.class);

      registerPacketClass(PlanarVelocityPacket.class);
      registerPacketField(Vector3D.class);

      registerPacketClass(QuadrupedForceControllerEventPacket.class);
      registerPacketField(QuadrupedForceControllerRequestedEvent.class);

      registerPacketClass(QuadrupedForceControllerStatePacket.class);
      registerPacketField(QuadrupedForceControllerEnum.class);

      registerPacketClass(QuadrupedXGaitSettingsPacket.class);
      registerPacketField(QuadrupedXGaitSettings.class);

      registerPacketField(String.class);
      registerPacketField(boolean.class);

      registerPacketField(String.class);
      registerPacketField(double[].class);

      registerPacketField(String.class);
      registerPacketField(double.class);

      registerPacketField(String.class);

      registerPacketClass(QuadrupedTimedStepPacket.class);
      registerPacketField(ArrayList.class);
      registerPacketField(QuadrupedTimedStep.class);
      registerPacketField(Point3D.class);
      registerPacketField(RobotQuadrant.class);
      registerPacketField(TimeInterval.class);

      registerPacketClass(QuadrupedSoleWaypointPacket.class);
      registerPacketClass(QuadrupedSteppingEventPacket.class);
   }
}
