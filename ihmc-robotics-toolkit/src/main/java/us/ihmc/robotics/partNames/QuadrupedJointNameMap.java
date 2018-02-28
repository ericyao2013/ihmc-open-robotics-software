package us.ihmc.robotics.partNames;

import us.ihmc.robotics.robotSide.RobotQuadrant;

public interface QuadrupedJointNameMap extends LeggedJointNameMap<RobotQuadrant>
{
   public String getLegJointName(RobotQuadrant robotQuadrant, LegJointName legJointName);

   public String getJointBeforeFootName(RobotQuadrant robotQuadrant);

   QuadrupedJointName getJointNameForSDFName(String name);

   String getSDFNameForJointName(QuadrupedJointName name);
}
