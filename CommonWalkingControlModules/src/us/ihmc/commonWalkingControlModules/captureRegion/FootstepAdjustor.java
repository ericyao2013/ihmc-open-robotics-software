package us.ihmc.commonWalkingControlModules.captureRegion;

import us.ihmc.euclid.geometry.ConvexPolygon2D;
import us.ihmc.euclid.referenceFrame.ReferenceFrame;
import us.ihmc.graphicsDescription.yoGraphics.YoGraphicsListRegistry;
import us.ihmc.humanoidRobotics.bipedSupportPolygons.ContactablePlaneBody;
import us.ihmc.humanoidRobotics.footstep.Footstep;
import us.ihmc.yoVariables.registry.YoVariableRegistry;
import us.ihmc.robotics.geometry.FrameConvexPolygon2d;
import us.ihmc.robotics.geometry.FramePoint3D;
import us.ihmc.robotics.geometry.FramePoint2D;
import us.ihmc.robotics.geometry.FrameVector2D;
import us.ihmc.robotics.robotSide.RobotSide;
import us.ihmc.robotics.robotSide.SideDependentList;

/**
 * Provides the function adjustFootstep which takes a footstep and a capture region
 * as arguments and projects the footstep into this region.
 * 
 * It is possible to provide stepping stones in this case the footstep will be projected
 * into the intersection between allowable region and stepping stones.
 * 
 * @author 
 *
 */
public class FootstepAdjustor
{
   private static final boolean VISUALIZE = true;
   private static final double SHRINK_TOUCHDOWN_POLYGON_FACTOR = 0.5;

   private final YoVariableRegistry registry = new YoVariableRegistry("FootstepAdjustor");

   private final SideDependentList<ConvexPolygon2D> defaultSupportPolygons;

   private FootstepAdjusterVisualizer footstepAdjusterVisualizer = null;
//   private SteppingStones steppingStones = null;

   public FootstepAdjustor(SideDependentList<? extends ContactablePlaneBody> contactableFeet, YoVariableRegistry parentRegistry,
         YoGraphicsListRegistry yoGraphicsListRegistry)
   {
      parentRegistry.addChild(registry);
      if (yoGraphicsListRegistry != null && VISUALIZE)
      {
         footstepAdjusterVisualizer = new FootstepAdjusterVisualizer(this, yoGraphicsListRegistry, registry);
      }

      defaultSupportPolygons = new SideDependentList<>();
      for (RobotSide robotSide : RobotSide.values)
      {
         defaultSupportPolygons.put(robotSide, new FrameConvexPolygon2d(contactableFeet.get(robotSide).getContactPoints2d()).getConvexPolygon2d());
      }
   }

   private final FrameConvexPolygon2d touchdownFootPolygon = new FrameConvexPolygon2d();
   private final FrameConvexPolygon2d desiredSteppingRegion = new FrameConvexPolygon2d();
   private final FrameConvexPolygon2d intersection = new FrameConvexPolygon2d();

   /**
    * This function takes a footstep and a captureRegion and if necessary projects the footstep
    * into the capture region. Returns true if the footstep was changed.
    */
   public boolean adjustFootstep(Footstep footstep, FramePoint2D supportCentroid, FrameConvexPolygon2d captureRegion)
   {
      boolean footstepChanged = false;

      // Check if there is a capture region
      if (captureRegion.isEmpty())
      {
         updateVisualizer();
         return footstepChanged;
      }

      // If there are stepping stones then intersect them with the capture region.
//      if (steppingStones == null)
      {
         desiredSteppingRegion.setIncludingFrameAndUpdate(captureRegion);
      }
//      else
//      {
//         updateDesiredSteppingRegion(captureRegion, steppingStones, footstep, desiredSteppingRegion);
//      }

      // Check if the desired footstep intersects the capture region.
      calculateTouchdownFootPolygon(footstep, desiredSteppingRegion.getReferenceFrame(), touchdownFootPolygon);
      boolean nextStepInside = desiredSteppingRegion.intersectionWith(touchdownFootPolygon, intersection);

      if (nextStepInside)
      {
         updateVisualizer();
         return footstepChanged;
      }
      else
      {
         footstepChanged = true;
      }

      // No overlap between touch-down polygon and capture region.
      projectFootstepInCaptureRegion(footstep, supportCentroid, desiredSteppingRegion);
      updateVisualizer();
      return footstepChanged;
   }

   private final FramePoint2D nextStep2d = new FramePoint2D();
   private final FramePoint2D projection = new FramePoint2D();
   private final FrameVector2D direction = new FrameVector2D();

   /** 
    * This function projects the footstep midpoint in the capture region.
    * Might be a bit conservative it should be sufficient to slightly overlap the capture region
    * and the touch-down polygon.
    */
   private void projectFootstepInCaptureRegion(Footstep footstep, FramePoint2D projectionPoint, FrameConvexPolygon2d captureRegion)
   {
      // this is only tested with footsteps in world frame
      ReferenceFrame footstepFrame = footstep.getFootstepPose().getReferenceFrame();
      footstepFrame.checkReferenceFrameMatch(ReferenceFrame.getWorldFrame());
      
      projection.setIncludingFrame(projectionPoint);
      projection.changeFrame(footstepFrame);

      // move the position of the footstep to the capture region centroid
      nextStep2d.setIncludingFrame(captureRegion.getCentroid());
      nextStep2d.changeFrame(footstepFrame);

      // move the position as far away from the projectionPoint as possible
      direction.setIncludingFrame(nextStep2d);
      direction.sub(projection);
      direction.normalize();
      direction.scale(10.0);
      nextStep2d.add(direction);

      nextStep2d.changeFrame(captureRegion.getReferenceFrame());
      captureRegion.orthogonalProjection(nextStep2d);
      nextStep2d.changeFrame(footstepFrame);

      footstep.setPositionChangeOnlyXY(nextStep2d);

      calculateTouchdownFootPolygon(footstep, captureRegion.getReferenceFrame(), touchdownFootPolygon);
   }

   private final FramePoint2D centroid2d = new FramePoint2D();
   private final FramePoint3D centroid3d = new FramePoint3D();

   /**
    * This function takes a footstep and calculates the touch-down polygon in the
    * desired reference frame
    */
   private void calculateTouchdownFootPolygon(Footstep footstep, ReferenceFrame desiredFrame, FrameConvexPolygon2d polygonToPack)
   {
      footstep.getPosition(centroid3d);
      centroid2d.setIncludingFrame(centroid3d);
      centroid2d.changeFrame(desiredFrame);

      polygonToPack.setIncludingFrameAndUpdate(footstep.getSoleReferenceFrame(), defaultSupportPolygons.get(footstep.getRobotSide()));
      polygonToPack.changeFrameAndProjectToXYPlane(desiredFrame);
      // shrink the polygon for safety by pulling all the corner points towards the center
      polygonToPack.scale(centroid2d, SHRINK_TOUCHDOWN_POLYGON_FACTOR);
   }

//   /**
//    * This function intersects the capture region with the stepping stones and returns the best
//    * intersecting polygon. Here 'best' means the one closest to the original footstep location.
//    */
//   private void updateDesiredSteppingRegion(FrameConvexPolygon2d captureRegion, SteppingStones steppingStones, Footstep footstep,
//         FrameConvexPolygon2d polygonToPack)
//   {
//      // TODO
//      //      polygonToPack.setIncludingFrameAndUpdate(captureRegion);
//      throw new RuntimeException("Implement me!");
//   }

//   public void setSteppingStones(SteppingStones steppingStones)
//   {
//      this.steppingStones = steppingStones;
//   }

   public FrameConvexPolygon2d getTouchdownFootPolygon()
   {
      return touchdownFootPolygon;
   }

   public void updateVisualizer()
   {
      if (footstepAdjusterVisualizer != null)
      {
         footstepAdjusterVisualizer.update();
      }
   }

   public void hideTouchdownPolygons()
   {
      if (footstepAdjusterVisualizer != null)
      {
         footstepAdjusterVisualizer.hide();
      }
   }
}
