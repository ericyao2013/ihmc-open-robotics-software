package controller_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * This message is part of the IHMC whole-body controller API.
 * The controller sends this message to notify the user of the status of walking.
 */
public class WalkingStatusMessage implements Settable<WalkingStatusMessage>, EpsilonComparable<WalkingStatusMessage>
{
   public static final byte STARTED = (byte) 0;
   public static final byte COMPLETED = (byte) 1;
   public static final byte ABORT_REQUESTED = (byte) 2;
   /**
    * Status of walking.
    */
   private byte walking_status_ = (byte) 255;

   public WalkingStatusMessage()
   {
   }

   public WalkingStatusMessage(WalkingStatusMessage other)
   {
      set(other);
   }

   public void set(WalkingStatusMessage other)
   {
      walking_status_ = other.walking_status_;
   }

   /**
    * Status of walking.
    */
   public byte getWalkingStatus()
   {
      return walking_status_;
   }

   /**
    * Status of walking.
    */
   public void setWalkingStatus(byte walking_status)
   {
      walking_status_ = walking_status;
   }

   @Override
   public boolean epsilonEquals(WalkingStatusMessage other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.walking_status_, other.walking_status_, epsilon))
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
      if (!(other instanceof WalkingStatusMessage))
         return false;

      WalkingStatusMessage otherMyClass = (WalkingStatusMessage) other;

      if (this.walking_status_ != otherMyClass.walking_status_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("WalkingStatusMessage {");
      builder.append("walking_status=");
      builder.append(this.walking_status_);

      builder.append("}");
      return builder.toString();
   }
}