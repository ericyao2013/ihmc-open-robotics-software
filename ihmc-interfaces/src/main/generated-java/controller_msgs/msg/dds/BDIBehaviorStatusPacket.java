package controller_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Atlas specific message.
 */
public class BDIBehaviorStatusPacket implements Settable<BDIBehaviorStatusPacket>, EpsilonComparable<BDIBehaviorStatusPacket>
{
   public static final byte NONE = (byte) 0;
   public static final byte FREEZE = (byte) 1;
   public static final byte STAND_PREP = (byte) 2;
   public static final byte STAND = (byte) 3;
   public static final byte WALK = (byte) 4;
   public static final byte STEP = (byte) 5;
   public static final byte MANIPULATE = (byte) 6;
   public static final byte USER = (byte) 7;
   public static final byte CALIBRATE = (byte) 8;
   public static final byte SOFT_STOP = (byte) 9;
   private byte current_bdi_robot_behavior_ = (byte) 255;

   public BDIBehaviorStatusPacket()
   {
   }

   public BDIBehaviorStatusPacket(BDIBehaviorStatusPacket other)
   {
      set(other);
   }

   public void set(BDIBehaviorStatusPacket other)
   {
      current_bdi_robot_behavior_ = other.current_bdi_robot_behavior_;
   }

   public byte getCurrentBdiRobotBehavior()
   {
      return current_bdi_robot_behavior_;
   }

   public void setCurrentBdiRobotBehavior(byte current_bdi_robot_behavior)
   {
      current_bdi_robot_behavior_ = current_bdi_robot_behavior;
   }

   @Override
   public boolean epsilonEquals(BDIBehaviorStatusPacket other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.current_bdi_robot_behavior_, other.current_bdi_robot_behavior_, epsilon))
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
      if (!(other instanceof BDIBehaviorStatusPacket))
         return false;

      BDIBehaviorStatusPacket otherMyClass = (BDIBehaviorStatusPacket) other;

      if (this.current_bdi_robot_behavior_ != otherMyClass.current_bdi_robot_behavior_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("BDIBehaviorStatusPacket {");
      builder.append("current_bdi_robot_behavior=");
      builder.append(this.current_bdi_robot_behavior_);

      builder.append("}");
      return builder.toString();
   }
}