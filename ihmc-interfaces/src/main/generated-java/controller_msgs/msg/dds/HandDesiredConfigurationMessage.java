package controller_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * This message is part of the IHMC whole-body controller API.
 * This message is old will be refreshed in a future release.
 * Message for commanding the hands to perform various predefined grasps.
 */
public class HandDesiredConfigurationMessage implements Settable<HandDesiredConfigurationMessage>, EpsilonComparable<HandDesiredConfigurationMessage>
{
   public static final byte ROBOT_SIDE_LEFT = (byte) 0;
   public static final byte ROBOT_SIDE_RIGHT = (byte) 1;
   public static final byte HAND_CONFIGURATION_STOP = (byte) 0;
   public static final byte HAND_CONFIGURATION_OPEN = (byte) 1;
   public static final byte HAND_CONFIGURATION_CLOSE = (byte) 2;
   public static final byte HAND_CONFIGURATION_CRUSH = (byte) 3;
   public static final byte HAND_CONFIGURATION_HOOK = (byte) 4;
   public static final byte HAND_CONFIGURATION_BASIC_GRIP = (byte) 5;
   public static final byte HAND_CONFIGURATION_PINCH_GRIP = (byte) 6;
   public static final byte HAND_CONFIGURATION_WIDE_GRIP = (byte) 7;
   public static final byte HAND_CONFIGURATION_SCISSOR_GRIP = (byte) 8;
   public static final byte HAND_CONFIGURATION_RESET = (byte) 9;
   public static final byte HAND_CONFIGURATION_OPEN_FINGERS = (byte) 10;
   public static final byte HAND_CONFIGURATION_OPEN_THUMB = (byte) 11;
   public static final byte HAND_CONFIGURATION_CLOSE_FINGERS = (byte) 12;
   public static final byte HAND_CONFIGURATION_CLOSE_THUMB = (byte) 13;
   public static final byte HAND_CONFIGURATION_OPEN_INDEX = (byte) 14;
   public static final byte HAND_CONFIGURATION_OPEN_MIDDLE = (byte) 15;
   public static final byte HAND_CONFIGURATION_HALF_CLOSE = (byte) 16;
   public static final byte HAND_CONFIGURATION_CONNECT = (byte) 17;
   public static final byte HAND_CONFIGURATION_CRUSH_INDEX = (byte) 18;
   public static final byte HAND_CONFIGURATION_CRUSH_MIDDLE = (byte) 19;
   public static final byte HAND_CONFIGURATION_CRUSH_THUMB = (byte) 20;
   public static final byte HAND_CONFIGURATION_INVERT_POWER = (byte) 21;
   public static final byte HAND_CONFIGURATION_T_SPREAD = (byte) 22;
   public static final byte HAND_CONFIGURATION_BEND_BACKWARD = (byte) 23;
   public static final byte HAND_CONFIGURATION_CALIBRATE = (byte) 24;
   public static final byte HAND_CONFIGURATION_FINGER_MANIPULATION = (byte) 25;
   public static final byte HAND_CONFIGURATION_PRE_CREEPY_GRASP = (byte) 26;
   public static final byte HAND_CONFIGURATION_PARTIAL_CREEPY_GRASP = (byte) 27;
   public static final byte HAND_CONFIGURATION_CREEPY_GRASPING = (byte) 28;
   public static final byte HAND_CONFIGURATION_CREEPY_GRASPING_HARD = (byte) 29;
   public static final byte HAND_CONFIGURATION_SLOW_CLOSE = (byte) 30;
   /**
    * Specifies the side of the robot that will execute the trajectory
    */
   private byte robot_side_ = (byte) 255;
   /**
    * Specifies the grasp to perform
    */
   private byte desired_hand_configuration_ = (byte) 255;

   public HandDesiredConfigurationMessage()
   {

   }

   public HandDesiredConfigurationMessage(HandDesiredConfigurationMessage other)
   {
      set(other);
   }

   public void set(HandDesiredConfigurationMessage other)
   {
      robot_side_ = other.robot_side_;

      desired_hand_configuration_ = other.desired_hand_configuration_;
   }

   /**
    * Specifies the side of the robot that will execute the trajectory
    */
   public byte getRobotSide()
   {
      return robot_side_;
   }

   /**
    * Specifies the side of the robot that will execute the trajectory
    */
   public void setRobotSide(byte robot_side)
   {
      robot_side_ = robot_side;
   }

   /**
    * Specifies the grasp to perform
    */
   public byte getDesiredHandConfiguration()
   {
      return desired_hand_configuration_;
   }

   /**
    * Specifies the grasp to perform
    */
   public void setDesiredHandConfiguration(byte desired_hand_configuration)
   {
      desired_hand_configuration_ = desired_hand_configuration;
   }

   @Override
   public boolean epsilonEquals(HandDesiredConfigurationMessage other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.robot_side_, other.robot_side_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.desired_hand_configuration_, other.desired_hand_configuration_, epsilon))
         return false;

      return true;
   }

   @Override
   public boolean equals(Object other)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;
      if (!(other instanceof HandDesiredConfigurationMessage))
         return false;

      HandDesiredConfigurationMessage otherMyClass = (HandDesiredConfigurationMessage) other;

      if (this.robot_side_ != otherMyClass.robot_side_)
         return false;

      if (this.desired_hand_configuration_ != otherMyClass.desired_hand_configuration_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("HandDesiredConfigurationMessage {");
      builder.append("robot_side=");
      builder.append(this.robot_side_);

      builder.append(", ");
      builder.append("desired_hand_configuration=");
      builder.append(this.desired_hand_configuration_);

      builder.append("}");
      return builder.toString();
   }
}