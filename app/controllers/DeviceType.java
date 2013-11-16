package controllers;

import java.util.List; 

public class DeviceType 
{
  private String typeName;
  private List<Sensor> sensors;  

  protected DeviceType(String typeName)
  {
    this.typeName = typeName;
  }

  protected void add(Sensor sensor)
  {
    sensors.add(sensor);
  }

  public String getType()
  {
    return typeName;
  }

  public List<Sensor> getSensors()
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
