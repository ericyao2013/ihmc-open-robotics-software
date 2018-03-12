package controller_msgs.msg.dds;

/**
 * Topic data type of the struct "HeightQuadTreeLeafMessage" defined in "HeightQuadTreeLeafMessage_.idl". Use this class to provide the TopicDataType to a Participant.
 *
 * This file was automatically generated from HeightQuadTreeLeafMessage_.idl by us.ihmc.idl.generator.IDLGenerator.
 * Do not update this file directly, edit HeightQuadTreeLeafMessage_.idl instead.
 */
public class HeightQuadTreeLeafMessagePubSubType implements us.ihmc.pubsub.TopicDataType<controller_msgs.msg.dds.HeightQuadTreeLeafMessage>
{
   public static final java.lang.String name = "controller_msgs::msg::dds_::HeightQuadTreeLeafMessage_";
   private final us.ihmc.idl.CDR serializeCDR = new us.ihmc.idl.CDR();
   private final us.ihmc.idl.CDR deserializeCDR = new us.ihmc.idl.CDR();

   public HeightQuadTreeLeafMessagePubSubType()
   {

   }

   public static int getMaxCdrSerializedSize()
   {
      return getMaxCdrSerializedSize(0);
   }

   public static int getMaxCdrSerializedSize(int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      return current_alignment - initial_alignment;
   }

   public final static int getCdrSerializedSize(controller_msgs.msg.dds.HeightQuadTreeLeafMessage data)
   {
      return getCdrSerializedSize(data, 0);
   }

   public final static int getCdrSerializedSize(controller_msgs.msg.dds.HeightQuadTreeLeafMessage data, int current_alignment)
   {
      int initial_alignment = current_alignment;

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      current_alignment += 4 + us.ihmc.idl.CDR.alignment(current_alignment, 4);

      return current_alignment - initial_alignment;
   }

   public static void write(controller_msgs.msg.dds.HeightQuadTreeLeafMessage data, us.ihmc.idl.CDR cdr)
   {

      cdr.write_type_5(data.getXCenter());

      cdr.write_type_5(data.getYCenter());

      cdr.write_type_5(data.getHeight());
   }

   public static void read(controller_msgs.msg.dds.HeightQuadTreeLeafMessage data, us.ihmc.idl.CDR cdr)
   {

      data.setXCenter(cdr.read_type_5());

      data.setYCenter(cdr.read_type_5());

      data.setHeight(cdr.read_type_5());
   }

   public static void staticCopy(controller_msgs.msg.dds.HeightQuadTreeLeafMessage src, controller_msgs.msg.dds.HeightQuadTreeLeafMessage dest)
   {
      dest.set(src);
   }

   @Override
   public void serialize(controller_msgs.msg.dds.HeightQuadTreeLeafMessage data, us.ihmc.pubsub.common.SerializedPayload serializedPayload)
         throws java.io.IOException
   {
      serializeCDR.serialize(serializedPayload);
      write(data, serializeCDR);
      serializeCDR.finishSerialize();
   }

   @Override
   public void deserialize(us.ihmc.pubsub.common.SerializedPayload serializedPayload, controller_msgs.msg.dds.HeightQuadTreeLeafMessage data)
         throws java.io.IOException
   {
      deserializeCDR.deserialize(serializedPayload);
      read(data, deserializeCDR);
      deserializeCDR.finishDeserialize();
   }

   @Override
   public final void serialize(controller_msgs.msg.dds.HeightQuadTreeLeafMessage data, us.ihmc.idl.InterchangeSerializer ser)
   {
      ser.write_type_5("x_center", data.getXCenter());

      ser.write_type_5("y_center", data.getYCenter());

      ser.write_type_5("height", data.getHeight());
   }

   @Override
   public final void deserialize(us.ihmc.idl.InterchangeSerializer ser, controller_msgs.msg.dds.HeightQuadTreeLeafMessage data)
   {
      data.setXCenter(ser.read_type_5("x_center"));

      data.setYCenter(ser.read_type_5("y_center"));

      data.setHeight(ser.read_type_5("height"));
   }

   @Override
   public controller_msgs.msg.dds.HeightQuadTreeLeafMessage createData()
   {
      return new controller_msgs.msg.dds.HeightQuadTreeLeafMessage();
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

   public void serialize(controller_msgs.msg.dds.HeightQuadTreeLeafMessage data, us.ihmc.idl.CDR cdr)
   {
      write(data, cdr);
   }

   public void deserialize(controller_msgs.msg.dds.HeightQuadTreeLeafMessage data, us.ihmc.idl.CDR cdr)
   {
      read(data, cdr);
   }

   public void copy(controller_msgs.msg.dds.HeightQuadTreeLeafMessage src, controller_msgs.msg.dds.HeightQuadTreeLeafMessage dest)
   {
      staticCopy(src, dest);
   }

   @Override
   public HeightQuadTreeLeafMessagePubSubType newInstance()
   {
      return new HeightQuadTreeLeafMessagePubSubType();
   }
}