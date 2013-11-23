package models;

import java.util.ArrayList;
import java.util.List;

public class DeviceType implements Comparable<DeviceType>
{
  private final String typeName;
  private List<SensorType> sensors;

  public DeviceType(String typeName)
  {
    this.typeName = typeName;
    this.sensors = new ArrayList<SensorType>();
  }

  public void add(SensorType sensorType)
  {
    sensors.add(sensorType);
  }

  public String getType()
  {
    return typeName;
  }

  public List<SensorType> getSensorTypes()
  {
    return sensors;
  }

   @Override
   public boolean equals(Object o)
   {
      if (o == this)
      {
         return true;
      }
      if (!(o instanceof DeviceType))
      {
         return false;
      }
      DeviceType dt = (DeviceType) o;
      return typeName.equals(dt.typeName);
   }

   @Override
   public int hashCode()
   {
      return typeName.hashCode();
   }
   
   public int compareTo(DeviceType dType)
   {
      if (this.typeName != null && dType.typeName != null)
      {
         return this.typeName.compareToIgnoreCase(dType.typeName);
      }
      return 0;
   }
}
