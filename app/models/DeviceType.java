package models;

import java.util.List;

public class DeviceType 
{
  private final String typeName;
  private List<SensorType> sensors;

  public DeviceType(String typeName)
  {
    this.typeName = typeName;
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
      DeviceType dt = (DeviceType)o;
      return typeName.equals(dt.typeName);
   }
   
   @Override
   public int hashCode()
   {
      return typeName.hashCode();
   }
}
