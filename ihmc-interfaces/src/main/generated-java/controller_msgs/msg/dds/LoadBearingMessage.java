package controller_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * This message is part of the IHMC whole-body controller API.
 * Message carrying the information needed to enable load bearing for a end-effector.
 * A contact point will be used to enable this feature. This point is attached to the end-effector.
 */
public class LoadBearingMessage implements Settable<LoadBearingMessage>, EpsilonComparable<LoadBearingMessage>
{
   /**
    * If set to true this will load the contact point. Otherwise the rigid body will stop bearing load.
    */
   private boolean load_;
   /**
    * Sets the coefficient of friction that the controller will use for the contact point.
    */
   private double coefficient_of_friction_;
   /**
    * Sets the pose of the contact frame in the frame of the end effector body.
    */
   private us.ihmc.euclid.geometry.Pose3D body_frame_to_control_frame_;
   /**
    * Sets the contact normal used by the controller to load the contact point.
    */
   private us.ihmc.euclid.tuple3D.Vector3D contact_normal_in_world_frame_;

   public LoadBearingMessage()
   {

      body_frame_to_control_frame_ = new us.ihmc.euclid.geometry.Pose3D();
      contact_normal_in_world_frame_ = new us.ihmc.euclid.tuple3D.Vector3D();
   }

   public LoadBearingMessage(LoadBearingMessage other)
   {
      set(other);
   }

   public void set(LoadBearingMessage other)
   {
      load_ = other.load_;

      coefficient_of_friction_ = other.coefficient_of_friction_;

      geometry_msgs.msg.dds.PosePubSubType.staticCopy(other.body_frame_to_control_frame_, body_frame_to_control_frame_);
      geometry_msgs.msg.dds.Vector3PubSubType.staticCopy(other.contact_normal_in_world_frame_, contact_normal_in_world_frame_);
   }

   /**
    * If set to true this will load the contact point. Otherwise the rigid body will stop bearing load.
    */
   public boolean getLoad()
   {
      return load_;
   }

   /**
    * If set to true this will load the contact point. Otherwise the rigid body will stop bearing load.
    */
   public void setLoad(boolean load)
   {
      load_ = load;
   }

   /**
    * Sets the coefficient of friction that the controller will use for the contact point.
    */
   public double getCoefficientOfFriction()
   {
      return coefficient_of_friction_;
   }

   /**
    * Sets the coefficient of friction that the controller will use for the contact point.
    */
   public void setCoefficientOfFriction(double coefficient_of_friction)
   {
      coefficient_of_friction_ = coefficient_of_friction;
   }

   /**
    * Sets the pose of the contact frame in the frame of the end effector body.
    */
   public us.ihmc.euclid.geometry.Pose3D getBodyFrameToControlFrame()
   {
      return body_frame_to_control_frame_;
   }

   /**
    * Sets the contact normal used by the controller to load the contact point.
    */
   public us.ihmc.euclid.tuple3D.Vector3D getContactNormalInWorldFrame()
   {
      return contact_normal_in_world_frame_;
   }

   @Override
   public boolean epsilonEquals(LoadBearingMessage other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsBoolean(this.load_, other.load_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.coefficient_of_friction_, other.coefficient_of_friction_, epsilon))
         return false;

      if (!this.body_frame_to_control_frame_.epsilonEquals(other.body_frame_to_control_frame_, epsilon))
         return false;

      if (!this.contact_normal_in_world_frame_.epsilonEquals(other.contact_normal_in_world_frame_, epsilon))
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
      if (!(other instanceof LoadBearingMessage))
         return false;

      LoadBearingMessage otherMyClass = (LoadBearingMessage) other;

      if (this.load_ != otherMyClass.load_)
         return false;

      if (this.coefficient_of_friction_ != otherMyClass.coefficient_of_friction_)
         return false;

      if (!this.body_frame_to_control_frame_.equals(otherMyClass.body_frame_to_control_frame_))
         return false;

      if (!this.contact_normal_in_world_frame_.equals(otherMyClass.contact_normal_in_world_frame_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("LoadBearingMessage {");
      builder.append("load=");
      builder.append(this.load_);

      builder.append(", ");
      builder.append("coefficient_of_friction=");
      builder.append(this.coefficient_of_friction_);

      builder.append(", ");
      builder.append("body_frame_to_control_frame=");
      builder.append(this.body_frame_to_control_frame_);

      builder.append(", ");
      builder.append("contact_normal_in_world_frame=");
      builder.append(this.contact_normal_in_world_frame_);

      builder.append("}");
      return builder.toString();
   }
}