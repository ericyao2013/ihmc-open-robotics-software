package us.ihmc.robotics.partNames;

import org.apache.commons.lang3.tuple.ImmutablePair;
import us.ihmc.euclid.transform.RigidBodyTransform;
import us.ihmc.robotics.robotSide.RobotSegment;

public interface LeggedJointNameMap<E extends Enum<E> & RobotSegment<E>> extends JointNameMap<E>
{
   ImmutablePair<E, LegJointName> getLegJointName(String jointName);

   ImmutablePair<E, LimbName> getLimbName(String limbName);

   String getJointBeforeFootName(E robotSegment);

   RigidBodyTransform getSoleToParentFrameTransform(E robotSegment);
}
