package us.ihmc.robotics.immutableRobotDescription;

import org.immutables.value.Value.Immutable;

@Immutable public abstract class ForceSensorDescription extends SensorDescription
{
   public abstract boolean getUseGroundContactPoints();

   public static ImmutableForceSensorDescription.Builder builder()
   {
      return ImmutableForceSensorDescription.builder();
   }
}
