package controllers;

public class SensorType
{
  private final String sensorType;

  protected SensorType(String sensorType)
  {
    this.sensorType = sensorType;
  }

  public String getType()
  {
    return sensorType;
  }
}
