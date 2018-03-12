package controller_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * This message is part of the IHMC whole-body controller API.
 * This class is used to build 1D trajectory messages including jointspace trajectory messages.
 * For 3D trajectory points look at:
 * - EuclideanTrajectoryMessage (translational),
 * - SO3TrajectoryPointMessage (rotational),
 * - SE3TrajectoryPointMessage (translational AND rotational).
 */
public class TrajectoryPoint1DMessage implements Settable<TrajectoryPoint1DMessage>, EpsilonComparable<TrajectoryPoint1DMessage>
{
   /**
    * Time at which the trajectory point has to be reached. The time is relative to when the trajectory starts.
    */
   private double time_;
   /**
    * Define the desired 1D position to be reached at this trajectory point.
    */
   private double position_;
   /**
    * Define the desired 1D velocity to be reached at this trajectory point.
    */
   private double velocity_;

   public TrajectoryPoint1DMessage()
   {

   }

   public TrajectoryPoint1DMessage(TrajectoryPoint1DMessage other)
   {
      set(other);
   }

   public void set(TrajectoryPoint1DMessage other)
   {
      time_ = other.time_;

      position_ = other.position_;

      velocity_ = other.velocity_;
   }

   /**
    * Time at which the trajectory point has to be reached. The time is relative to when the trajectory starts.
    */
   public double getTime()
   {
      return time_;
   }

   /**
    * Time at which the trajectory point has to be reached. The time is relative to when the trajectory starts.
    */
   public void setTime(double time)
   {
      time_ = time;
   }

   /**
    * Define the desired 1D position to be reached at this trajectory point.
    */
   public double getPosition()
   {
      return position_;
   }

   /**
    * Define the desired 1D position to be reached at this trajectory point.
    */
   public void setPosition(double position)
   {
      position_ = position;
   }

   /**
    * Define the desired 1D velocity to be reached at this trajectory point.
    */
   public double getVelocity()
   {
      return velocity_;
   }

   /**
    * Define the desired 1D velocity to be reached at this trajectory point.
    */
   public void setVelocity(double velocity)
   {
      velocity_ = velocity;
   }

   @Override
   public boolean epsilonEquals(TrajectoryPoint1DMessage other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.time_, other.time_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.position_, other.position_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.velocity_, other.velocity_, epsilon))
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
      if (!(other instanceof TrajectoryPoint1DMessage))
         return false;

      TrajectoryPoint1DMessage otherMyClass = (TrajectoryPoint1DMessage) other;

      if (this.time_ != otherMyClass.time_)
         return false;

      if (this.position_ != otherMyClass.position_)
         return false;

      if (this.velocity_ != otherMyClass.velocity_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("TrajectoryPoint1DMessage {");
      builder.append("time=");
      builder.append(this.time_);

      builder.append(", ");
      builder.append("position=");
      builder.append(this.position_);

      builder.append(", ");
      builder.append("velocity=");
      builder.append(this.velocity_);

      builder.append("}");
      return builder.toString();
   }
}