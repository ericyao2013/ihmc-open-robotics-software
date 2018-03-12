package controller_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * This message is part of the IHMC whole-body controller API.
 * This message commands the controller to move in taskspace the head to the desired orientation while going through the specified trajectory points.
 * A Hermite based curve (third order) is used to interpolate the orientations.
 * To execute a simple trajectory to reach a desired head orientation, set only one trajectory point with zero velocity and its time to be equal to the desired trajectory time.
 */
public class HeadTrajectoryMessage implements Settable<HeadTrajectoryMessage>, EpsilonComparable<HeadTrajectoryMessage>
{
   /**
    * The orientation trajectory information.
    */
   private controller_msgs.msg.dds.SO3TrajectoryMessage so3_trajectory_;

   public HeadTrajectoryMessage()
   {
      so3_trajectory_ = new controller_msgs.msg.dds.SO3TrajectoryMessage();
   }

   public HeadTrajectoryMessage(HeadTrajectoryMessage other)
   {
      set(other);
   }

   public void set(HeadTrajectoryMessage other)
   {
      controller_msgs.msg.dds.SO3TrajectoryMessagePubSubType.staticCopy(other.so3_trajectory_, so3_trajectory_);
   }

   /**
    * The orientation trajectory information.
    */
   public controller_msgs.msg.dds.SO3TrajectoryMessage getSo3Trajectory()
   {
      return so3_trajectory_;
   }

   @Override
   public boolean epsilonEquals(HeadTrajectoryMessage other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!this.so3_trajectory_.epsilonEquals(other.so3_trajectory_, epsilon))
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
      if (!(other instanceof HeadTrajectoryMessage))
         return false;

      HeadTrajectoryMessage otherMyClass = (HeadTrajectoryMessage) other;

      if (!this.so3_trajectory_.equals(otherMyClass.so3_trajectory_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("HeadTrajectoryMessage {");
      builder.append("so3_trajectory=");
      builder.append(this.so3_trajectory_);

      builder.append("}");
      return builder.toString();
   }
}