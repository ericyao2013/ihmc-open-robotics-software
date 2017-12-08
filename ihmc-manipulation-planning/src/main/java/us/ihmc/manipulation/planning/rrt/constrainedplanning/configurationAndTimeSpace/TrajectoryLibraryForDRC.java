package us.ihmc.manipulation.planning.rrt.constrainedplanning.configurationAndTimeSpace;

import us.ihmc.commons.PrintTools;
import us.ihmc.euclid.axisAngle.AxisAngle;
import us.ihmc.euclid.geometry.Pose3D;
import us.ihmc.euclid.matrix.RotationMatrix;
import us.ihmc.euclid.transform.RigidBodyTransform;
import us.ihmc.euclid.tuple3D.Point3D;
import us.ihmc.euclid.tuple3D.Vector3D;

public class TrajectoryLibraryForDRC
{
   /**
    * (knobGraspingPose) is a pose to grasp door knob.
    * The axis for twisting knob is located toward the z-direction of the (knobGraspingPose).
    * The axis for opening door is located toward the reverse z-direction of the (knobGraspingPose).
    */
   public static Pose3D computeDoorOpeningTrajectory(double time, double trajectoryTime, double openingRadius, double openingAngle, boolean openingDirectionCW,
                                                     Pose3D knobGraspingPose, double twistTime, double twistRadius, double twistAngle, boolean twistDirectionCW)
   {
      RigidBodyTransform handControl = new RigidBodyTransform(knobGraspingPose.getOrientation(), knobGraspingPose.getPosition());

      double distanceBetweenKnobAndDoor = 0.0;
      Vector3D zVectorOfKnob = new Vector3D();
      handControl.getRotationMatrix().getColumn(2, zVectorOfKnob);
      
      Vector3D translationFromKnobToDoorPlane = new Vector3D();          
      
      if(zVectorOfKnob.getY() > 0)
      {
         translationFromKnobToDoorPlane.setX(zVectorOfKnob.getY());
         translationFromKnobToDoorPlane.setY(-zVectorOfKnob.getX());   
      }
      else
      {
         translationFromKnobToDoorPlane.setX(-zVectorOfKnob.getY());
         translationFromKnobToDoorPlane.setY(zVectorOfKnob.getX());
      }
      Vector3D twistAxis = new Vector3D(translationFromKnobToDoorPlane);   // toward knob center to door plane.
      
      translationFromKnobToDoorPlane.scale(distanceBetweenKnobAndDoor);
     
      
      
      // twist
      {
         double phase = time / twistTime;
         if(phase > 1.0)
            phase = 1.0;
         handControl.appendTranslation(0, 0, twistRadius);
      
         twistAxis.normalize();
         AxisAngle twistAxisAngle = new AxisAngle(twistAxis, twistDirectionCW ? (twistAngle * phase) : (-twistAngle * phase));
         
         handControl.multiply(new RigidBodyTransform(twistAxisAngle, new Point3D()));
         handControl.appendTranslation(0, 0, -twistRadius);
      }

      // opening      
      if(time > twistTime)
      {
         double phase = (time - twistTime) / (trajectoryTime - twistTime);
         
         RigidBodyTransform knobCenterControl = new RigidBodyTransform(knobGraspingPose.getOrientation(), knobGraspingPose.getPosition());
         RotationMatrix knobCenterOrientationControl = new RotationMatrix(knobGraspingPose.getOrientation());
         knobCenterControl.prependTranslation(translationFromKnobToDoorPlane);
         knobCenterControl.appendTranslation(0, 0, twistRadius-openingRadius);
         
//         PrintTools.info(""+knobCenterControl.getTranslationVector());
                  
         knobCenterOrientationControl.prependYawRotation(openingDirectionCW ? (-openingAngle * phase) : (openingAngle * phase));
         knobCenterControl.setRotation(knobCenterOrientationControl);
         
//         PrintTools.info(""+knobCenterControl.getTranslationVector());
         
         knobCenterControl.appendTranslation(0, 0, -twistRadius+openingRadius);
         
//         PrintTools.info(""+knobCenterControl.getTranslationVector());
         
         translationFromKnobToDoorPlane.negate();
         knobCenterControl.prependTranslation(translationFromKnobToDoorPlane);
         
         
         handControl = new RigidBodyTransform(knobCenterControl);
         handControl.appendTranslation(0, 0, twistRadius);
         
         twistAxis.normalize();
         AxisAngle twistAxisAngle = new AxisAngle(twistAxis, twistDirectionCW ? (twistAngle * 1.0) : (-twistAngle * 1.0));
         handControl.multiply(new RigidBodyTransform(twistAxisAngle, new Point3D()));
         handControl.appendTranslation(0, 0, -twistRadius);
      }
      
      //PrintTools.info(""+handControl.getTranslationVector());
  
      return new Pose3D(handControl);
   }
}
