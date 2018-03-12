package controller_msgs.msg.dds;

import us.ihmc.euclid.interfaces.EpsilonComparable;
import us.ihmc.euclid.interfaces.Settable;

/**
 * This message is part of the IHMC whole-body controller API.
 * General message carrying the information needed to safely queue messages.
 */
public class QueueableMessage implements Settable<QueueableMessage>, EpsilonComparable<QueueableMessage>
{
   public static final byte EXECUTION_MODE_OVERRIDE = (byte) 0;
   public static final byte EXECUTION_MODE_QUEUE = (byte) 1;
   /**
    * When EXECUTION_MODE_OVERRIDE is chosen:
    * - For trajectory messages: the time of the first trajectory point can be zero, in which case the controller will start directly at the first trajectory point.
    * Otherwise the controller will prepend a first trajectory point at the current desired position.
    * When EXECUTION_MODE_QUEUE is chosen:
    * - The message must carry the ID of the message it should be queued to.
    * - The very first message of a list of queued messages has to be an EXECUTION_MODE_OVERRIDE message.
    * - For trajectory messages:
    * - the trajectory point times are relative to the the last trajectory point time of the previous message.
    * - the time of the first trajectory point has to be greater than zero.
    * - When joint-space trajectory: the controller will queue the joint trajectory messages as a per joint basis.
    */
   private byte execution_mode_;
   /**
    * Defines a unique ID for this message. Only needed when you want to queue another message to this message.
    */
   private long message_id_ = 1;
   /**
    * Only needed when using EXECUTION_MODE_QUEUE mode, it refers to the message_id to which this message should be queued to.
    * It is used by the controller to ensure that no message has been lost on the way.
    * If a message appears to be missing (previous_message_id different from the last message_id received by the controller), the motion is aborted.
    */
   private long previous_message_id_;
   /**
    * The time to delay this message on the controller side before being executed.
    */
   private double execution_delay_time_;

   public QueueableMessage()
   {

   }

   public QueueableMessage(QueueableMessage other)
   {
      set(other);
   }

   public void set(QueueableMessage other)
   {
      execution_mode_ = other.execution_mode_;

      message_id_ = other.message_id_;

      previous_message_id_ = other.previous_message_id_;

      execution_delay_time_ = other.execution_delay_time_;
   }

   /**
    * When EXECUTION_MODE_OVERRIDE is chosen:
    * - For trajectory messages: the time of the first trajectory point can be zero, in which case the controller will start directly at the first trajectory point.
    * Otherwise the controller will prepend a first trajectory point at the current desired position.
    * When EXECUTION_MODE_QUEUE is chosen:
    * - The message must carry the ID of the message it should be queued to.
    * - The very first message of a list of queued messages has to be an EXECUTION_MODE_OVERRIDE message.
    * - For trajectory messages:
    * - the trajectory point times are relative to the the last trajectory point time of the previous message.
    * - the time of the first trajectory point has to be greater than zero.
    * - When joint-space trajectory: the controller will queue the joint trajectory messages as a per joint basis.
    */
   public byte getExecutionMode()
   {
      return execution_mode_;
   }

   /**
    * When EXECUTION_MODE_OVERRIDE is chosen:
    * - For trajectory messages: the time of the first trajectory point can be zero, in which case the controller will start directly at the first trajectory point.
    * Otherwise the controller will prepend a first trajectory point at the current desired position.
    * When EXECUTION_MODE_QUEUE is chosen:
    * - The message must carry the ID of the message it should be queued to.
    * - The very first message of a list of queued messages has to be an EXECUTION_MODE_OVERRIDE message.
    * - For trajectory messages:
    * - the trajectory point times are relative to the the last trajectory point time of the previous message.
    * - the time of the first trajectory point has to be greater than zero.
    * - When joint-space trajectory: the controller will queue the joint trajectory messages as a per joint basis.
    */
   public void setExecutionMode(byte execution_mode)
   {
      execution_mode_ = execution_mode;
   }

   /**
    * Defines a unique ID for this message. Only needed when you want to queue another message to this message.
    */
   public long getMessageId()
   {
      return message_id_;
   }

   /**
    * Defines a unique ID for this message. Only needed when you want to queue another message to this message.
    */
   public void setMessageId(long message_id)
   {
      message_id_ = message_id;
   }

   /**
    * Only needed when using EXECUTION_MODE_QUEUE mode, it refers to the message_id to which this message should be queued to.
    * It is used by the controller to ensure that no message has been lost on the way.
    * If a message appears to be missing (previous_message_id different from the last message_id received by the controller), the motion is aborted.
    */
   public long getPreviousMessageId()
   {
      return previous_message_id_;
   }

   /**
    * Only needed when using EXECUTION_MODE_QUEUE mode, it refers to the message_id to which this message should be queued to.
    * It is used by the controller to ensure that no message has been lost on the way.
    * If a message appears to be missing (previous_message_id different from the last message_id received by the controller), the motion is aborted.
    */
   public void setPreviousMessageId(long previous_message_id)
   {
      previous_message_id_ = previous_message_id;
   }

   /**
    * The time to delay this message on the controller side before being executed.
    */
   public double getExecutionDelayTime()
   {
      return execution_delay_time_;
   }

   /**
    * The time to delay this message on the controller side before being executed.
    */
   public void setExecutionDelayTime(double execution_delay_time)
   {
      execution_delay_time_ = execution_delay_time;
   }

   @Override
   public boolean epsilonEquals(QueueableMessage other, double epsilon)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.execution_mode_, other.execution_mode_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.message_id_, other.message_id_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.previous_message_id_, other.previous_message_id_, epsilon))
         return false;

      if (!us.ihmc.idl.IDLTools.epsilonEqualsPrimitive(this.execution_delay_time_, other.execution_delay_time_, epsilon))
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
      if (!(other instanceof QueueableMessage))
         return false;

      QueueableMessage otherMyClass = (QueueableMessage) other;

      if (this.execution_mode_ != otherMyClass.execution_mode_)
         return false;

      if (this.message_id_ != otherMyClass.message_id_)
         return false;

      if (this.previous_message_id_ != otherMyClass.previous_message_id_)
         return false;

      if (this.execution_delay_time_ != otherMyClass.execution_delay_time_)
         return false;

      return true;
   }

   @Override
   public java.lang.String toString()
   {
      StringBuilder builder = new StringBuilder();

      builder.append("QueueableMessage {");
      builder.append("execution_mode=");
      builder.append(this.execution_mode_);

      builder.append(", ");
      builder.append("message_id=");
      builder.append(this.message_id_);

      builder.append(", ");
      builder.append("previous_message_id=");
      builder.append(this.previous_message_id_);

      builder.append(", ");
      builder.append("execution_delay_time=");
      builder.append(this.execution_delay_time_);

      builder.append("}");
      return builder.toString();
   }
}