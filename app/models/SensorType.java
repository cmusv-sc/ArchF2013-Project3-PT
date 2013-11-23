package models;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SensorType implements Comparable<SensorType>
{
   private final String sensorType;

   public SensorType(String sensorType)
   {
      this.sensorType = sensorType;
   }

   public String getType()
   {
      return sensorType;
   }

   public static Set<SensorType> parseSensorTypeList(
         final String sensorTypeTokens)
   {
      Set<SensorType> sensorTypes = new HashSet<SensorType>();
      if (sensorTypeTokens != null && !sensorTypeTokens.isEmpty())
      {
         StringTokenizer tokenizer = new StringTokenizer(sensorTypeTokens, ",");
         while (tokenizer.hasMoreElements())
         {
            sensorTypes.add(new SensorType(tokenizer.nextToken()));
         }
      }
      return sensorTypes;
   }

   @Override
   public boolean equals(Object o)
   {
      if (o == this)
      {
         return true;
      }
      if (!(o instanceof SensorType))
      {
         return false;
      }
      SensorType st = (SensorType) o;
      return sensorType.equals(st.sensorType);
   }

   @Override
   public int hashCode()
   {
      return sensorType.hashCode();
   }
   
   public int compareTo(SensorType sType)
   {
      if (this.sensorType != null && sType.sensorType != null)
      {
         return this.sensorType.compareToIgnoreCase(sType.sensorType);
      }
      return 0;
   }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SensorType{");
        sb.append("sensorType='").append(sensorType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
