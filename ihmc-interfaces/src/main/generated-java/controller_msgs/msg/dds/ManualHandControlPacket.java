package controller_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Atlas specific message
 */
public class ManualHandControlPacket implements Settable<ManualHandControlPacket>, EpsilonComparable<ManualHandControlPacket>
{
   public static final byte ROBOT_SIDE_LEFT = (byte) 0;
   public static final byte ROBOT_SIDE_RIGHT = (byte) 1;
   public static final int VELOCITY = 0;
   public static final int POSITION = 1;
   private byte robot_side_ = (byte) 255;
   private double index_;
   private double middle_;
   private double thumb_;
   private double spread_;
   private int control_type_;

   public ManualHandControlPacket()
   {

   }

   public ManualHandControlPacket(ManualHandControlPacket other)
   {
      set(other);
   }

   public void set(ManualHandControlPacket other)
   {
      robot_side_ = other.robot_side_;

      index_ = other.index_;

      middle_ = other.middle_;

      thumb_ = other.thumb_;

      spread_ = other.spread_;

      control_type_ = other.control_type_;
   }

   public byte getRobotSide()
   {
      return robot_side_;
   }

   public void setRobotSide(byte robot_side)
   {
      robot_side_ = robot_side;
   }

   public double getIndex()
   {
      return index_;
   }

   public void setIndex(double index)
   {
      index_ = index;
   }

   public double getMiddle()
   {
      return middle_;
   }

   public void setMiddle(double middle)
   {
      middle_ = middle;
   }

   public double getThumb()
   {
      return thumb_;
   }

   public void setThumb(double thumb)
   {
      thumb_ = thumb;
   }

   public double getSpread()
   {
      return spread_;
   }

   public void setSpread(double spread)
   {
      spread_ = spread;
   }

   public int getControlType()
   {
      return control_type_;
   }

   public void setControlType(int control_type)
   {
      control_type_ = control_type;
   }

   @Override
   public boolean epsilonEquals(ManualHandControlPacket other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.robot_side_, other.robot_side_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.index_, other.index_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.middle_, other.middle_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.thumb_, other.thumb_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.spread_, other.spread_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.control_type_, other.control_type_, epsilon))
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
      if (!(other instanceof ManualHandControlPacket))
         return false;

      ManualHandControlPacket otherMyClass = (ManualHandControlPacket) other;

      if (this.robot_side_ != otherMyClass.robot_side_)
         return false;

      if (this.index_ != otherMyClass.index_)
         return false;

      if (this.middle_ != otherMyClass.middle_)
         return false;

      if (this.thumb_ != otherMyClass.thumb_)
         return false;

      if (this.spread_ != otherMyClass.spread_)
         return false;

      if (this.control_type_ != otherMyClass.control_type_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ManualHandControlPacket {");
      builder.append("robot_side=");
      builder.append(this.robot_side_);

      builder.append(", ");
      builder.append("index=");
      builder.append(this.index_);

      builder.append(", ");
      builder.append("middle=");
      builder.append(this.middle_);

      builder.append(", ");
      builder.append("thumb=");
      builder.append(this.thumb_);

      builder.append(", ");
      builder.append("spread=");
      builder.append(this.spread_);

      builder.append(", ");
      builder.append("control_type=");
      builder.append(this.control_type_);

      builder.append("}");
      return builder.toString();
   }
}