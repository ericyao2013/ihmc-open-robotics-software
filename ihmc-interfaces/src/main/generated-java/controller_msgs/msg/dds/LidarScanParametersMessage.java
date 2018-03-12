package controller_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Message used for simulated LIDAR
 */
public class LidarScanParametersMessage implements Settable<LidarScanParametersMessage>, EpsilonComparable<LidarScanParametersMessage>
{
   private long timestamp_;
   private float sweep_yaw_max_;
   private float sweep_yaw_min_;
   private float height_pitch_max_;
   private float height_pitch_min_;
   private float time_increment_;
   private float scan_time_;
   private float min_range_;
   private float max_range_;
   private int points_per_sweep_;
   private int scan_height_;

   public LidarScanParametersMessage()
   {

   }

   public LidarScanParametersMessage(LidarScanParametersMessage other)
   {
      set(other);
   }

   public void set(LidarScanParametersMessage other)
   {
      timestamp_ = other.timestamp_;

      sweep_yaw_max_ = other.sweep_yaw_max_;

      sweep_yaw_min_ = other.sweep_yaw_min_;

      height_pitch_max_ = other.height_pitch_max_;

      height_pitch_min_ = other.height_pitch_min_;

      time_increment_ = other.time_increment_;

      scan_time_ = other.scan_time_;

      min_range_ = other.min_range_;

      max_range_ = other.max_range_;

      points_per_sweep_ = other.points_per_sweep_;

      scan_height_ = other.scan_height_;
   }

   public long getTimestamp()
   {
      return timestamp_;
   }

   public void setTimestamp(long timestamp)
   {
      timestamp_ = timestamp;
   }

   public float getSweepYawMax()
   {
      return sweep_yaw_max_;
   }

   public void setSweepYawMax(float sweep_yaw_max)
   {
      sweep_yaw_max_ = sweep_yaw_max;
   }

   public float getSweepYawMin()
   {
      return sweep_yaw_min_;
   }

   public void setSweepYawMin(float sweep_yaw_min)
   {
      sweep_yaw_min_ = sweep_yaw_min;
   }

   public float getHeightPitchMax()
   {
      return height_pitch_max_;
   }

   public void setHeightPitchMax(float height_pitch_max)
   {
      height_pitch_max_ = height_pitch_max;
   }

   public float getHeightPitchMin()
   {
      return height_pitch_min_;
   }

   public void setHeightPitchMin(float height_pitch_min)
   {
      height_pitch_min_ = height_pitch_min;
   }

   public float getTimeIncrement()
   {
      return time_increment_;
   }

   public void setTimeIncrement(float time_increment)
   {
      time_increment_ = time_increment;
   }

   public float getScanTime()
   {
      return scan_time_;
   }

   public void setScanTime(float scan_time)
   {
      scan_time_ = scan_time;
   }

   public float getMinRange()
   {
      return min_range_;
   }

   public void setMinRange(float min_range)
   {
      min_range_ = min_range;
   }

   public float getMaxRange()
   {
      return max_range_;
   }

   public void setMaxRange(float max_range)
   {
      max_range_ = max_range;
   }

   public int getPointsPerSweep()
   {
      return points_per_sweep_;
   }

   public void setPointsPerSweep(int points_per_sweep)
   {
      points_per_sweep_ = points_per_sweep;
   }

   public int getScanHeight()
   {
      return scan_height_;
   }

   public void setScanHeight(int scan_height)
   {
      scan_height_ = scan_height;
   }

   @Override
   public boolean epsilonEquals(LidarScanParametersMessage other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.timestamp_, other.timestamp_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.sweep_yaw_max_, other.sweep_yaw_max_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.sweep_yaw_min_, other.sweep_yaw_min_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.height_pitch_max_, other.height_pitch_max_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.height_pitch_min_, other.height_pitch_min_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.time_increment_, other.time_increment_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.scan_time_, other.scan_time_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.min_range_, other.min_range_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.max_range_, other.max_range_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.points_per_sweep_, other.points_per_sweep_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.scan_height_, other.scan_height_, epsilon))
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
      if (!(other instanceof LidarScanParametersMessage))
         return false;

      LidarScanParametersMessage otherMyClass = (LidarScanParametersMessage) other;

      if (this.timestamp_ != otherMyClass.timestamp_)
         return false;

      if (this.sweep_yaw_max_ != otherMyClass.sweep_yaw_max_)
         return false;

      if (this.sweep_yaw_min_ != otherMyClass.sweep_yaw_min_)
         return false;

      if (this.height_pitch_max_ != otherMyClass.height_pitch_max_)
         return false;

      if (this.height_pitch_min_ != otherMyClass.height_pitch_min_)
         return false;

      if (this.time_increment_ != otherMyClass.time_increment_)
         return false;

      if (this.scan_time_ != otherMyClass.scan_time_)
         return false;

      if (this.min_range_ != otherMyClass.min_range_)
         return false;

      if (this.max_range_ != otherMyClass.max_range_)
         return false;

      if (this.points_per_sweep_ != otherMyClass.points_per_sweep_)
         return false;

      if (this.scan_height_ != otherMyClass.scan_height_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("LidarScanParametersMessage {");
      builder.append("timestamp=");
      builder.append(this.timestamp_);

      builder.append(", ");
      builder.append("sweep_yaw_max=");
      builder.append(this.sweep_yaw_max_);

      builder.append(", ");
      builder.append("sweep_yaw_min=");
      builder.append(this.sweep_yaw_min_);

      builder.append(", ");
      builder.append("height_pitch_max=");
      builder.append(this.height_pitch_max_);

      builder.append(", ");
      builder.append("height_pitch_min=");
      builder.append(this.height_pitch_min_);

      builder.append(", ");
      builder.append("time_increment=");
      builder.append(this.time_increment_);

      builder.append(", ");
      builder.append("scan_time=");
      builder.append(this.scan_time_);

      builder.append(", ");
      builder.append("min_range=");
      builder.append(this.min_range_);

      builder.append(", ");
      builder.append("max_range=");
      builder.append(this.max_range_);

      builder.append(", ");
      builder.append("points_per_sweep=");
      builder.append(this.points_per_sweep_);

      builder.append(", ");
      builder.append("scan_height=");
      builder.append(this.scan_height_);

      builder.append("}");
      return builder.toString();
   }
}