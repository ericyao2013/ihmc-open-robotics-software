package controller_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * Message used to encode the manifold of an object to be used as input by a reaching motion planner.
 * Main usage is the IHMC WholeBodyTrajectoryToolbox.
 */
public class ReachingManifoldMessage implements Settable<ReachingManifoldMessage>, EpsilonComparable<ReachingManifoldMessage>
{
   public static final byte CONFIGURATION_SPACE_NAME_X = (byte) 0;
   public static final byte CONFIGURATION_SPACE_NAME_Y = (byte) 1;
   public static final byte CONFIGURATION_SPACE_NAME_Z = (byte) 2;
   public static final byte CONFIGURATION_SPACE_NAME_ROLL = (byte) 3;
   public static final byte CONFIGURATION_SPACE_NAME_PITCH = (byte) 4;
   public static final byte CONFIGURATION_SPACE_NAME_YAW = (byte) 5;
   private long end_effector_name_based_hash_code_;
   private us.ihmc.euclid.tuple3D.Point3D manifold_origin_position_;
   private us.ihmc.euclid.tuple4D.Quaternion manifold_origin_orientation_;
   private us.ihmc.idl.IDLSequence.Byte manifold_configuration_space_names_;
   private us.ihmc.idl.IDLSequence.Double manifold_lower_limits_;
   private us.ihmc.idl.IDLSequence.Double manifold_upper_limits_;

   public ReachingManifoldMessage()
   {

      manifold_origin_position_ = new us.ihmc.euclid.tuple3D.Point3D();
      manifold_origin_orientation_ = new us.ihmc.euclid.tuple4D.Quaternion();
      manifold_configuration_space_names_ = new us.ihmc.idl.IDLSequence.Byte(100, "type_9");

      manifold_lower_limits_ = new us.ihmc.idl.IDLSequence.Double(100, "type_6");

      manifold_upper_limits_ = new us.ihmc.idl.IDLSequence.Double(100, "type_6");
   }

   public ReachingManifoldMessage(ReachingManifoldMessage other)
   {
      set(other);
   }

   public void set(ReachingManifoldMessage other)
   {
      end_effector_name_based_hash_code_ = other.end_effector_name_based_hash_code_;

      geometry_msgs.msg.dds.PointPubSubType.staticCopy(other.manifold_origin_position_, manifold_origin_position_);
      geometry_msgs.msg.dds.QuaternionPubSubType.staticCopy(other.manifold_origin_orientation_, manifold_origin_orientation_);
      manifold_configuration_space_names_.set(other.manifold_configuration_space_names_);
      manifold_lower_limits_.set(other.manifold_lower_limits_);
      manifold_upper_limits_.set(other.manifold_upper_limits_);
   }

   public long getEndEffectorNameBasedHashCode()
   {
      return end_effector_name_based_hash_code_;
   }

   public void setEndEffectorNameBasedHashCode(long end_effector_name_based_hash_code)
   {
      end_effector_name_based_hash_code_ = end_effector_name_based_hash_code;
   }

   public us.ihmc.euclid.tuple3D.Point3D getManifoldOriginPosition()
   {
      return manifold_origin_position_;
   }

   public us.ihmc.euclid.tuple4D.Quaternion getManifoldOriginOrientation()
   {
      return manifold_origin_orientation_;
   }

   public us.ihmc.idl.IDLSequence.Byte getManifoldConfigurationSpaceNames()
   {
      return manifold_configuration_space_names_;
   }

   public us.ihmc.idl.IDLSequence.Double getManifoldLowerLimits()
   {
      return manifold_lower_limits_;
   }

   public us.ihmc.idl.IDLSequence.Double getManifoldUpperLimits()
   {
      return manifold_upper_limits_;
   }

   @Override
   public boolean epsilonEquals(ReachingManifoldMessage other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.end_effector_name_based_hash_code_, other.end_effector_name_based_hash_code_, epsilon))
         return false;

      if (!this.manifold_origin_position_.epsilonEquals(other.manifold_origin_position_, epsilon))
         return false;

      if (!this.manifold_origin_orientation_.epsilonEquals(other.manifold_origin_orientation_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsByteSequence(this.manifold_configuration_space_names_, other.manifold_configuration_space_names_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.manifold_lower_limits_, other.manifold_lower_limits_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsDoubleSequence(this.manifold_upper_limits_, other.manifold_upper_limits_, epsilon))
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
      if (!(other instanceof ReachingManifoldMessage))
         return false;

      ReachingManifoldMessage otherMyClass = (ReachingManifoldMessage) other;

      if (this.end_effector_name_based_hash_code_ != otherMyClass.end_effector_name_based_hash_code_)
         return false;

      if (!this.manifold_origin_position_.equals(otherMyClass.manifold_origin_position_))
         return false;

      if (!this.manifold_origin_orientation_.equals(otherMyClass.manifold_origin_orientation_))
         return false;

      if (!this.manifold_configuration_space_names_.equals(otherMyClass.manifold_configuration_space_names_))
         return false;

      if (!this.manifold_lower_limits_.equals(otherMyClass.manifold_lower_limits_))
         return false;

      if (!this.manifold_upper_limits_.equals(otherMyClass.manifold_upper_limits_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("ReachingManifoldMessage {");
      builder.append("end_effector_name_based_hash_code=");
      builder.append(this.end_effector_name_based_hash_code_);

      builder.append(", ");
      builder.append("manifold_origin_position=");
      builder.append(this.manifold_origin_position_);

      builder.append(", ");
      builder.append("manifold_origin_orientation=");
      builder.append(this.manifold_origin_orientation_);

      builder.append(", ");
      builder.append("manifold_configuration_space_names=");
      builder.append(this.manifold_configuration_space_names_);

      builder.append(", ");
      builder.append("manifold_lower_limits=");
      builder.append(this.manifold_lower_limits_);

      builder.append(", ");
      builder.append("manifold_upper_limits=");
      builder.append(this.manifold_upper_limits_);

      builder.append("}");
      return builder.toString();
   }
}