package us.ihmc.SdfLoader.partNames;

import org.apache.commons.lang3.StringUtils;

public enum NeckJointName
{
   LOWER_NECK_PITCH, NECK_YAW, UPPER_NECK_PITCH, NECK_ROLL;

   /**
    * @deprecated Do not iterate over these values!
    */
   public static final NeckJointName[] values = values();
   
   public String getCamelCaseNameForStartOfExpression()
   {
      switch (this)
      {
         case LOWER_NECK_PITCH :
         {
            return "lowerNeckPitch";
         }

         case NECK_YAW :
         {
            return "neckYaw";
         }

         case UPPER_NECK_PITCH :
         {
            return "upperNeckPitch";
         }
         
         case NECK_ROLL :
         {
        	 return "neckRoll";
         }

         default :
         {
            throw new RuntimeException("Should not get to here");
         }
      }
   }

   public String getCamelCaseNameForMiddleOfExpression()
   {
      return StringUtils.capitalize(getCamelCaseNameForStartOfExpression());
   }

   @Override
   public String toString()
   {
      return getCamelCaseNameForMiddleOfExpression();
   }
}
