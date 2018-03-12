package controller_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * This message is part of the IHMC robot environment awareness module.
 * Use this message to request new planar regions
 */
public class RequestPlanarRegionsListMessage implements Settable<RequestPlanarRegionsListMessage>, EpsilonComparable<RequestPlanarRegionsListMessage>
{
   public static final byte SINGLE_UPDATE = (byte) 0;
   public static final byte CONTINUOUS_UPDATE = (byte) 1;
   public static final byte STOP_UPDATE = (byte) 2;
   public static final byte CLEAR = (byte) 3;
   private byte planar_regions_request_type_;
   private controller_msgs.msg.dds.BoundingBox3DMessage bounding_box_in_world_for_request_;

   public RequestPlanarRegionsListMessage()
   {

      bounding_box_in_world_for_request_ = new controller_msgs.msg.dds.BoundingBox3DMessage();
   }

   public RequestPlanarRegionsListMessage(RequestPlanarRegionsListMessage other)
   {
      set(other);
   }

   public void set(RequestPlanarRegionsListMessage other)
   {
      planar_regions_request_type_ = other.planar_regions_request_type_;

      controller_msgs.msg.dds.BoundingBox3DMessagePubSubType.staticCopy(other.bounding_box_in_world_for_request_, bounding_box_in_world_for_request_);
   }

   public byte getPlanarRegionsRequestType()
   {
      return planar_regions_request_type_;
   }

   public void setPlanarRegionsRequestType(byte planar_regions_request_type)
   {
      planar_regions_request_type_ = planar_regions_request_type;
   }

   public controller_msgs.msg.dds.BoundingBox3DMessage getBoundingBoxInWorldForRequest()
   {
      return bounding_box_in_world_for_request_;
   }

   @Override
   public boolean epsilonEquals(RequestPlanarRegionsListMessage other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.planar_regions_request_type_, other.planar_regions_request_type_, epsilon))
         return false;

      if (!this.bounding_box_in_world_for_request_.epsilonEquals(other.bounding_box_in_world_for_request_, epsilon))
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
      if (!(other instanceof RequestPlanarRegionsListMessage))
         return false;

      RequestPlanarRegionsListMessage otherMyClass = (RequestPlanarRegionsListMessage) other;

      if (this.planar_regions_request_type_ != otherMyClass.planar_regions_request_type_)
         return false;

      if (!this.bounding_box_in_world_for_request_.equals(otherMyClass.bounding_box_in_world_for_request_))
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("RequestPlanarRegionsListMessage {");
      builder.append("planar_regions_request_type=");
      builder.append(this.planar_regions_request_type_);

      builder.append(", ");
      builder.append("bounding_box_in_world_for_request=");
      builder.append(this.bounding_box_in_world_for_request_);

      builder.append("}");
      return builder.toString();
   }
}