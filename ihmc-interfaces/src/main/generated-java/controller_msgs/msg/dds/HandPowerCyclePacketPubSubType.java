package controller_msgs.msg.dds;

/**
 * Topic data type of the struct "HandPowerCyclePacket" defined in "HandPowerCyclePacket_.idl". Use this class to provide the TopicDataType to a Participant.
 *
 * This file was automatically generated from HandPowerCyclePacket_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit HandPowerCyclePacket_.idl instead.
 */
public class HandPowerCyclePacketPubSubType implements us.ihmc.pubsub.TopicDataType<controller_msgs.msg.dds.HandPowerCyclePacket>
{
   public static final java.lang.String name = "controller_msgs::msg::dds_::HandPowerCyclePacket_";
   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   public HandPowerCyclePacketPubSubType()
   {

   }

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(controller_msgs.msg.dds.HandPowerCyclePacket data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(controller_msgs.msg.dds.HandPowerCyclePacket data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 1 + us.ihmc.idl.CDR.alignment(current_alignment, 1);

      return current_alignment - initial_alignment;
   }

   public static void write(controller_msgs.msg.dds.HandPowerCyclePacket data, us.ihmc.idl.CDR cdr)
   {

      cdr.write_type_9(data.getRobotSide());
   }

   public static void read(controller_msgs.msg.dds.HandPowerCyclePacket data, us.ihmc.idl.CDR cdr)
   {

      data.setRobotSide(cdr.read_type_9());
   }

   public static void staticCopy(controller_msgs.msg.dds.HandPowerCyclePacket src, controller_msgs.msg.dds.HandPowerCyclePacket dest)
   {
      dest.set(src);
   }

   @Override
   public void serialize(controller_msgs.msg.dds.HandPowerCyclePacket data, us.ihmc.pubsub.common.SerializedPayload serializedPayload)
         throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, controller_msgs.msg.dds.HandPowerCyclePacket data)
         throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public final void serialize(controller_msgs.msg.dds.HandPowerCyclePacket data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_9("robot_side", data.getRobotSide());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, controller_msgs.msg.dds.HandPowerCyclePacket data)
   {
      data.setRobotSide(ser.read_type_9("robot_side"));
   }

   @Override
   public controller_msgs.msg.dds.HandPowerCyclePacket createData()
   {
      return new controller_msgs.msg.dds.HandPowerCyclePacket();
   }

   @Override
   public int getTypeSize()
   {
      return us.ihmc.idl.CDR.getTypeSize(getMaxCdrSerializedSize());
   }

   @Override
   public java.lang.String getName()
   {
      return name;
   }

   public void serialize(controller_msgs.msg.dds.HandPowerCyclePacket data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(controller_msgs.msg.dds.HandPowerCyclePacket data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }

   public void copy(controller_msgs.msg.dds.HandPowerCyclePacket src, controller_msgs.msg.dds.HandPowerCyclePacket dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public HandPowerCyclePacketPubSubType newInstance()
   {
      return new HandPowerCyclePacketPubSubType();
   }
}