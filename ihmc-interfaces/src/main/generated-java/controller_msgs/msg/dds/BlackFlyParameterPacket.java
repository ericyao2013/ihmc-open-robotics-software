package controller_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Atlas specific message
 */
public class BlackFlyParameterPacket implements Settable<BlackFlyParameterPacket>, EpsilonComparable<BlackFlyParameterPacket>
{
   public static final byte ROBOT_SIDE_LEFT = (byte) 0;
   public static final byte ROBOT_SIDE_RIGHT = (byte) 1;
   private boolean auto_exposure_;
   private boolean auto_gain_;
   private boolean auto_shutter_;
   private double exposure_;
   private double frame_rate_;
   private boolean from_ui_;
   private double gain_;
   private double shutter_;
   private byte robot_side_ = (byte) 255;

   public BlackFlyParameterPacket()
   {

   }

   public BlackFlyParameterPacket(BlackFlyParameterPacket other)
   {
      set(other);
   }

   public void set(BlackFlyParameterPacket other)
   {
      auto_exposure_ = other.auto_exposure_;

      auto_gain_ = other.auto_gain_;

      auto_shutter_ = other.auto_shutter_;

      exposure_ = other.exposure_;

      frame_rate_ = other.frame_rate_;

      from_ui_ = other.from_ui_;

      gain_ = other.gain_;

      shutter_ = other.shutter_;

      robot_side_ = other.robot_side_;
   }

   public boolean getAutoExposure()
   {
      return auto_exposure_;
   }

   public void setAutoExposure(boolean auto_exposure)
   {
      auto_exposure_ = auto_exposure;
   }

   public boolean getAutoGain()
   {
      return auto_gain_;
   }

   public void setAutoGain(boolean auto_gain)
   {
      auto_gain_ = auto_gain;
   }

   public boolean getAutoShutter()
   {
      return auto_shutter_;
   }

   public void setAutoShutter(boolean auto_shutter)
   {
      auto_shutter_ = auto_shutter;
   }

   public double getExposure()
   {
      return exposure_;
   }

   public void setExposure(double exposure)
   {
      exposure_ = exposure;
   }

   public double getFrameRate()
   {
      return frame_rate_;
   }

   public void setFrameRate(double frame_rate)
   {
      frame_rate_ = frame_rate;
   }

   public boolean getFromUi()
   {
      return from_ui_;
   }

   public void setFromUi(boolean from_ui)
   {
      from_ui_ = from_ui;
   }

   public double getGain()
   {
      return gain_;
   }

   public void setGain(double gain)
   {
      gain_ = gain;
   }

   public double getShutter()
   {
      return shutter_;
   }

   public void setShutter(double shutter)
   {
      shutter_ = shutter;
   }

   public byte getRobotSide()
   {
      return robot_side_;
   }

   public void setRobotSide(byte robot_side)
   {
      robot_side_ = robot_side;
   }

   @Override
   public boolean epsilonEquals(BlackFlyParameterPacket other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.auto_exposure_, other.auto_exposure_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.auto_gain_, other.auto_gain_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.auto_shutter_, other.auto_shutter_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.exposure_, other.exposure_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.frame_rate_, other.frame_rate_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.from_ui_, other.from_ui_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.gain_, other.gain_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.shutter_, other.shutter_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.robot_side_, other.robot_side_, epsilon))
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
      if (!(other instanceof BlackFlyParameterPacket))
         return false;

      BlackFlyParameterPacket otherMyClass = (BlackFlyParameterPacket) other;

      if (this.auto_exposure_ != otherMyClass.auto_exposure_)
         return false;

      if (this.auto_gain_ != otherMyClass.auto_gain_)
         return false;

      if (this.auto_shutter_ != otherMyClass.auto_shutter_)
         return false;

      if (this.exposure_ != otherMyClass.exposure_)
         return false;

      if (this.frame_rate_ != otherMyClass.frame_rate_)
         return false;

      if (this.from_ui_ != otherMyClass.from_ui_)
         return false;

      if (this.gain_ != otherMyClass.gain_)
         return false;

      if (this.shutter_ != otherMyClass.shutter_)
         return false;

      if (this.robot_side_ != otherMyClass.robot_side_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("BlackFlyParameterPacket {");
      builder.append("auto_exposure=");
      builder.append(this.auto_exposure_);

      builder.append(", ");
      builder.append("auto_gain=");
      builder.append(this.auto_gain_);

      builder.append(", ");
      builder.append("auto_shutter=");
      builder.append(this.auto_shutter_);

      builder.append(", ");
      builder.append("exposure=");
      builder.append(this.exposure_);

      builder.append(", ");
      builder.append("frame_rate=");
      builder.append(this.frame_rate_);

      builder.append(", ");
      builder.append("from_ui=");
      builder.append(this.from_ui_);

      builder.append(", ");
      builder.append("gain=");
      builder.append(this.gain_);

      builder.append(", ");
      builder.append("shutter=");
      builder.append(this.shutter_);

      builder.append(", ");
      builder.append("robot_side=");
      builder.append(this.robot_side_);

      builder.append("}");
      return builder.toString();
   }
}