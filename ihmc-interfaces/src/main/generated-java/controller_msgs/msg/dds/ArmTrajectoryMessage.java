package controller_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * This message is part of the IHMC whole-body controller API.
 * This message commands the controller to move an arm in jointspace to the desired joint angles while going through the specified trajectory points.
 */
public class ArmTrajectoryMessage implements Settable<ArmTrajectoryMessage>, EpsilonComparable<ArmTrajectoryMessage>
{
   public static final byte ROBOT_SIDE_LEFT = (byte) 0;
   public static final byte ROBOT_SIDE_RIGHT = (byte) 1;
   /**
    * Specifies the side of the robot that will execute the trajectory.
    */
   private byte robot_side_ = (byte) 255;
   /**
    * Trajectories for each joint.
    * The indexing for the joints goes increasingly from the first shoulder joint to the last arm joint.
    */
   private controller_msgs.msg.dds.JointspaceTrajectoryMessage jointspace_trajectory_;

   public ArmTrajectoryMessage()
   {

      jointspace_trajectory_ = new controller_msgs.msg.dds.JointspaceTrajectoryMessage();
   }

   public ArmTrajectoryMessage(ArmTrajectoryMessage other)
   {
      set(other);
   }

   public void set(ArmTrajectoryMessage other)
   {
      robot_side_ = other.robot_side_;

      controller_msgs.msg.dds.JointspaceTrajectoryMessagePubSubType.staticCopy(other.jointspace_trajectory_, jointspace_trajectory_);
   }

   /**
    * Specifies the side of the robot that will execute the trajectory.
    */
   public byte getRobotSide()
   {
      return robot_side_;
   }

   /**
    * Specifies the side of the robot that will execute the trajectory.
    */
   public void setRobotSide(byte robot_side)
   {
      robot_side_ = robot_side;
   }

   /**
    * Trajectories for each joint.
    * The indexing for the joints goes increasingly from the first shoulder joint to the last arm joint.
    */
   public controller_msgs.msg.dds.JointspaceTrajectoryMessage getJointspaceTrajectory()
   {
      return jointspace_trajectory_;
   }

   @Override
   public boolean epsilonEquals(ArmTrajectoryMessage other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.robot_side_, other.robot_side_, epsilon))
         return false;

      if (!this.jointspace_trajectory_.epsilonEquals(other.jointspace_trajectory_, epsilon))
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
      if (!(other instanceof ArmTrajectoryMessage))
         return false;

      ArmTrajectoryMessage otherMyClass = (ArmTrajectoryMessage) other;

      if (this.robot_side_ != otherMyClass.robot_side_)
         return false;

      if (!this.jointspace_trajectory_.equals(otherMyClass.jointspace_trajectory_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ArmTrajectoryMessage {");
      builder.append("robot_side=");
      builder.append(this.robot_side_);

      builder.append(", ");
      builder.append("jointspace_trajectory=");
      builder.append(this.jointspace_trajectory_);

      builder.append("}");
      return builder.toString();
   }
}