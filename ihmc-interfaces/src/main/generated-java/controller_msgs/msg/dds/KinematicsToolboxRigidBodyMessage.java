package controller_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * This message is part of the IHMC hole-body inverse kinematics module.
 * This message contains all the information needed to configure the objectives/constraints to apply on
 * a given end-effector in the solver.
 */
public class KinematicsToolboxRigidBodyMessage implements Settable<KinematicsToolboxRigidBodyMessage>, EpsilonComparable<KinematicsToolboxRigidBodyMessage>
{
   /**
    * The is the unique hash code of the end-effector to be solved for.
    * It is used on the solver side to retrieve the desired end-effector to be controlled.
    * See RigidBody.getNameBasedHashCode() for the computation of a rigid-body hash code.
    */
   private long end_effector_name_based_hash_code_;
   /**
    * This is the desired position of the control frame's origin.
    * If the control frame has not been defined, it represents the desired position endEffector.getBodyFixedFrame().
    * The data is assumed to be expressed in world frame.
    */
   private us.ihmc.euclid.tuple3D.Point3D desired_position_in_world_;
   /**
    * This is the desired orientation of the control frame.
    * I the control frame has not been defined, it represents the desired orientation of endEffector.getBodyFixedFrame().
    * The data is assumed to be expressed in world frame.
    */
   private us.ihmc.euclid.tuple4D.Quaternion desired_orientation_in_world_;
   /**
    * This is the position of the control frame's origin expressed in endEffector.getBodyFixedFrame().
    * By default, the control frame is coincident to endEffector.getBodyFixedFrame().
    * The control frame is rigidly attached to the end-effector.
    */
   private us.ihmc.euclid.tuple3D.Point3D control_frame_position_in_end_effector_;
   /**
    * This is the orientation of the control frame expressed in endEffector.getBodyFixedFrame().
    * By default, the control frame is coincident to endEffector.getBodyFixedFrame().
    */
   private us.ihmc.euclid.tuple4D.Quaternion control_frame_orientation_in_end_effector_;
   /**
    * The selection matrix is used to determinate which degree of freedom of the end-effector should
    * be controlled.
    * The selection frames coming along with the given selection matrix are used to determine to
    * what reference frame the selected axes are referring to. For instance, if only the hand height
    * in world should be controlled on the linear z component of the selection matrix should be
    * selected and the reference frame should be world frame. When no reference frame is provided
    * with the selection matrix, it will be used as it is in the control frame, i.e. the body-fixed
    * frame if not defined otherwise.
    */
   private controller_msgs.msg.dds.SelectionMatrix3DMessage angular_selection_matrix_;
   /**
    * The selection matrix is used to determinate which degree of freedom of the end-effector should
    * be controlled.
    * The selection frames coming along with the given selection matrix are used to determine to
    * what reference frame the selected axes are referring to. For instance, if only the hand height
    * in world should be controlled on the linear z component of the selection matrix should be
    * selected and the reference frame should be world frame. When no reference frame is provided
    * with the selection matrix, it will be used as it is in the control frame, i.e. the body-fixed
    * frame if not defined otherwise.
    */
   private controller_msgs.msg.dds.SelectionMatrix3DMessage linear_selection_matrix_;
   /**
    * Weight matrix used to define the priority of controlling the rotation around each axis on the solver side.
    */
   private controller_msgs.msg.dds.WeightMatrix3DMessage angular_weight_matrix_;
   /**
    * Weight matrix used to define the priority of controlling the translation around each axis on the solver side.
    */
   private controller_msgs.msg.dds.WeightMatrix3DMessage linear_weight_matrix_;

   public KinematicsToolboxRigidBodyMessage()
   {

      desired_position_in_world_ = new us.ihmc.euclid.tuple3D.Point3D();
      desired_orientation_in_world_ = new us.ihmc.euclid.tuple4D.Quaternion();
      control_frame_position_in_end_effector_ = new us.ihmc.euclid.tuple3D.Point3D();
      control_frame_orientation_in_end_effector_ = new us.ihmc.euclid.tuple4D.Quaternion();
      angular_selection_matrix_ = new controller_msgs.msg.dds.SelectionMatrix3DMessage();
      linear_selection_matrix_ = new controller_msgs.msg.dds.SelectionMatrix3DMessage();
      angular_weight_matrix_ = new controller_msgs.msg.dds.WeightMatrix3DMessage();
      linear_weight_matrix_ = new controller_msgs.msg.dds.WeightMatrix3DMessage();
   }

   public KinematicsToolboxRigidBodyMessage(KinematicsToolboxRigidBodyMessage other)
   {
      set(other);
   }

   public void set(KinematicsToolboxRigidBodyMessage other)
   {
      end_effector_name_based_hash_code_ = other.end_effector_name_based_hash_code_;

      geometry_msgs.msg.dds.PointPubSubType.staticCopy(other.desired_position_in_world_, desired_position_in_world_);
      geometry_msgs.msg.dds.QuaternionPubSubType.staticCopy(other.desired_orientation_in_world_, desired_orientation_in_world_);
      geometry_msgs.msg.dds.PointPubSubType.staticCopy(other.control_frame_position_in_end_effector_, control_frame_position_in_end_effector_);
      geometry_msgs.msg.dds.QuaternionPubSubType.staticCopy(other.control_frame_orientation_in_end_effector_, control_frame_orientation_in_end_effector_);
      controller_msgs.msg.dds.SelectionMatrix3DMessagePubSubType.staticCopy(other.angular_selection_matrix_, angular_selection_matrix_);
      controller_msgs.msg.dds.SelectionMatrix3DMessagePubSubType.staticCopy(other.linear_selection_matrix_, linear_selection_matrix_);
      controller_msgs.msg.dds.WeightMatrix3DMessagePubSubType.staticCopy(other.angular_weight_matrix_, angular_weight_matrix_);
      controller_msgs.msg.dds.WeightMatrix3DMessagePubSubType.staticCopy(other.linear_weight_matrix_, linear_weight_matrix_);
   }

   /**
    * The is the unique hash code of the end-effector to be solved for.
    * It is used on the solver side to retrieve the desired end-effector to be controlled.
    * See RigidBody.getNameBasedHashCode() for the computation of a rigid-body hash code.
    */
   public long getEndEffectorNameBasedHashCode()
   {
      return end_effector_name_based_hash_code_;
   }

   /**
    * The is the unique hash code of the end-effector to be solved for.
    * It is used on the solver side to retrieve the desired end-effector to be controlled.
    * See RigidBody.getNameBasedHashCode() for the computation of a rigid-body hash code.
    */
   public void setEndEffectorNameBasedHashCode(long end_effector_name_based_hash_code)
   {
      end_effector_name_based_hash_code_ = end_effector_name_based_hash_code;
   }

   /**
    * This is the desired position of the control frame's origin.
    * If the control frame has not been defined, it represents the desired position endEffector.getBodyFixedFrame().
    * The data is assumed to be expressed in world frame.
    */
   public us.ihmc.euclid.tuple3D.Point3D getDesiredPositionInWorld()
   {
      return desired_position_in_world_;
   }

   /**
    * This is the desired orientation of the control frame.
    * I the control frame has not been defined, it represents the desired orientation of endEffector.getBodyFixedFrame().
    * The data is assumed to be expressed in world frame.
    */
   public us.ihmc.euclid.tuple4D.Quaternion getDesiredOrientationInWorld()
   {
      return desired_orientation_in_world_;
   }

   /**
    * This is the position of the control frame's origin expressed in endEffector.getBodyFixedFrame().
    * By default, the control frame is coincident to endEffector.getBodyFixedFrame().
    * The control frame is rigidly attached to the end-effector.
    */
   public us.ihmc.euclid.tuple3D.Point3D getControlFramePositionInEndEffector()
   {
      return control_frame_position_in_end_effector_;
   }

   /**
    * This is the orientation of the control frame expressed in endEffector.getBodyFixedFrame().
    * By default, the control frame is coincident to endEffector.getBodyFixedFrame().
    */
   public us.ihmc.euclid.tuple4D.Quaternion getControlFrameOrientationInEndEffector()
   {
      return control_frame_orientation_in_end_effector_;
   }

   /**
    * The selection matrix is used to determinate which degree of freedom of the end-effector should
    * be controlled.
    * The selection frames coming along with the given selection matrix are used to determine to
    * what reference frame the selected axes are referring to. For instance, if only the hand height
    * in world should be controlled on the linear z component of the selection matrix should be
    * selected and the reference frame should be world frame. When no reference frame is provided
    * with the selection matrix, it will be used as it is in the control frame, i.e. the body-fixed
    * frame if not defined otherwise.
    */
   public controller_msgs.msg.dds.SelectionMatrix3DMessage getAngularSelectionMatrix()
   {
      return angular_selection_matrix_;
   }

   /**
    * The selection matrix is used to determinate which degree of freedom of the end-effector should
    * be controlled.
    * The selection frames coming along with the given selection matrix are used to determine to
    * what reference frame the selected axes are referring to. For instance, if only the hand height
    * in world should be controlled on the linear z component of the selection matrix should be
    * selected and the reference frame should be world frame. When no reference frame is provided
    * with the selection matrix, it will be used as it is in the control frame, i.e. the body-fixed
    * frame if not defined otherwise.
    */
   public controller_msgs.msg.dds.SelectionMatrix3DMessage getLinearSelectionMatrix()
   {
      return linear_selection_matrix_;
   }

   /**
    * Weight matrix used to define the priority of controlling the rotation around each axis on the solver side.
    */
   public controller_msgs.msg.dds.WeightMatrix3DMessage getAngularWeightMatrix()
   {
      return angular_weight_matrix_;
   }

   /**
    * Weight matrix used to define the priority of controlling the translation around each axis on the solver side.
    */
   public controller_msgs.msg.dds.WeightMatrix3DMessage getLinearWeightMatrix()
   {
      return linear_weight_matrix_;
   }

   @Override
   public boolean epsilonEquals(KinematicsToolboxRigidBodyMessage other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.end_effector_name_based_hash_code_, other.end_effector_name_based_hash_code_, epsilon))
         return false;

      if (!this.desired_position_in_world_.epsilonEquals(other.desired_position_in_world_, epsilon))
         return false;

      if (!this.desired_orientation_in_world_.epsilonEquals(other.desired_orientation_in_world_, epsilon))
         return false;

      if (!this.control_frame_position_in_end_effector_.epsilonEquals(other.control_frame_position_in_end_effector_, epsilon))
         return false;

      if (!this.control_frame_orientation_in_end_effector_.epsilonEquals(other.control_frame_orientation_in_end_effector_, epsilon))
         return false;

      if (!this.angular_selection_matrix_.epsilonEquals(other.angular_selection_matrix_, epsilon))
         return false;

      if (!this.linear_selection_matrix_.epsilonEquals(other.linear_selection_matrix_, epsilon))
         return false;

      if (!this.angular_weight_matrix_.epsilonEquals(other.angular_weight_matrix_, epsilon))
         return false;

      if (!this.linear_weight_matrix_.epsilonEquals(other.linear_weight_matrix_, epsilon))
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
      if (!(other instanceof KinematicsToolboxRigidBodyMessage))
         return false;

      KinematicsToolboxRigidBodyMessage otherMyClass = (KinematicsToolboxRigidBodyMessage) other;

      if (this.end_effector_name_based_hash_code_ != otherMyClass.end_effector_name_based_hash_code_)
         return false;

      if (!this.desired_position_in_world_.equals(otherMyClass.desired_position_in_world_))
         return false;

      if (!this.desired_orientation_in_world_.equals(otherMyClass.desired_orientation_in_world_))
         return false;

      if (!this.control_frame_position_in_end_effector_.equals(otherMyClass.control_frame_position_in_end_effector_))
         return false;

      if (!this.control_frame_orientation_in_end_effector_.equals(otherMyClass.control_frame_orientation_in_end_effector_))
         return false;

      if (!this.angular_selection_matrix_.equals(otherMyClass.angular_selection_matrix_))
         return false;

      if (!this.linear_selection_matrix_.equals(otherMyClass.linear_selection_matrix_))
         return false;

      if (!this.angular_weight_matrix_.equals(otherMyClass.angular_weight_matrix_))
         return false;

      if (!this.linear_weight_matrix_.equals(otherMyClass.linear_weight_matrix_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("KinematicsToolboxRigidBodyMessage {");
      builder.append("end_effector_name_based_hash_code=");
      builder.append(this.end_effector_name_based_hash_code_);

      builder.append(", ");
      builder.append("desired_position_in_world=");
      builder.append(this.desired_position_in_world_);

      builder.append(", ");
      builder.append("desired_orientation_in_world=");
      builder.append(this.desired_orientation_in_world_);

      builder.append(", ");
      builder.append("control_frame_position_in_end_effector=");
      builder.append(this.control_frame_position_in_end_effector_);

      builder.append(", ");
      builder.append("control_frame_orientation_in_end_effector=");
      builder.append(this.control_frame_orientation_in_end_effector_);

      builder.append(", ");
      builder.append("angular_selection_matrix=");
      builder.append(this.angular_selection_matrix_);

      builder.append(", ");
      builder.append("linear_selection_matrix=");
      builder.append(this.linear_selection_matrix_);

      builder.append(", ");
      builder.append("angular_weight_matrix=");
      builder.append(this.angular_weight_matrix_);

      builder.append(", ");
      builder.append("linear_weight_matrix=");
      builder.append(this.linear_weight_matrix_);

      builder.append("}");
      return builder.toString();
   }
}