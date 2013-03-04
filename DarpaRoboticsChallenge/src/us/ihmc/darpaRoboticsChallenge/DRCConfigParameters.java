package us.ihmc.darpaRoboticsChallenge;

import us.ihmc.graphics3DAdapter.camera.VideoSettings;
import us.ihmc.graphics3DAdapter.camera.VideoSettings.Quality;
import us.ihmc.graphics3DAdapter.camera.VideoSettingsH264LowLatency;

public class DRCConfigParameters
{
   // Set to simulate one tick delay between, as it will be in Gazebo. This will also run the controller in a different thread!
   public static final boolean SIMULATE_DELAY = true;
   
   
   // Set whether or not to use GFE Robot Model
   public static final boolean USE_GFE_ROBOT_MODEL = true;

   // Convenience field
   public static final boolean USE_R2_ROBOT_MODEL = !USE_GFE_ROBOT_MODEL;

   public static final boolean STREAM_VIDEO = true;

   // Networking
   public static final String SCS_MACHINE_IP_ADDRESS = "localhost"; //"10.100.0.37";
   public static final int NETWORK_TCP_PORT = 4893;
   public static final int NETWORK_UDP_PORT = NETWORK_TCP_PORT + 1;
   
   public static final String OPERATOR_INTERFACE_IP_ADDRESS = "localhost"; //"10.4.8.1";

   public static final long ROBOT_JOINT_SERVER_UPDATE_MILLIS = 100;

//   public static final boolean STREAM_VANILLA_LIDAR = false;  getting rid of the vanilla lidar.
   public static final boolean STREAM_POLAR_LIDAR = true;

   public static final VideoSettings VIDEOSETTINGS = new VideoSettingsH264LowLatency(800, 600, Quality.MEDIUM);
   //   public static final VideoSettings VIDEOSETTINGS = new VideoSettingsH264LowLatency(200, 150, Quality.LOW);

   static final int LIDAR_UPDATE_RATE_OVERRIDE = 3;

//   static final double LIDAR_VERTICAL_SCAN_ANGLE = 0.9;

//   static final double LIDAR_HORIZONTAL_SCAN_ANGLE = 0.1;

   static final int LIDAR_SWEEPS_PER_SCAN = 6;//1

   static final int LIDAR_POINTS_PER_SWEEP = 70;//640

   static final boolean OVERRIDE_DRC_LIDAR_CONFIG = true;

   static final double MIN_LIDAR_DISTANCE = 0.2;

   public static final float LIDAR_MIN_DISTANCE = 0.2f;

   public static final float LIDAR_SWEEP_MAX_YAW = 0.8f;

   public static final float LIDAR_SWEEP_MIN_YAW = -0.8f;

   public static final float LIDAR_SCAN_MAX_ROLL = 0.4f; // rolling the lidar to simulated a faster update rate

   public static final float LDIAR_SCAN_MIN_ROLL = -0.3f;
   
   public static final int KERNEL_SIZE = 34; // 34 centimeters square

   public static final double GRID_RESOLUTION = 0.01;// 1 centimeter resolution

   public static final double LIDAR_BLINDNESS_CYLINDAR_SQUARED_RADIUS = 0.3;

}
