package controllers;

import java.util.List; 

public class DeviceType 
{
  private final String typeName;
  private List<SensorType> sensors;  

  protected DeviceType(String typeName)
  {
    this.typeName = typeName;
  }

  protected void add(SensorType sensorType)
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
    if (o == this){ 
      return true;
    }
    if (
  }
}
