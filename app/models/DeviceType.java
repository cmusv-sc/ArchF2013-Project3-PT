package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Comparable representation of DeviceType
 * A DeviceType contains a name identifer
 * as well as a list of SensorTypes that it supports
 * 
 * @author Team Mercury
 */
public class DeviceType implements Comparable<DeviceType>
{
  /** the identfier for this DeviceType (ex: Firefly_V3) */
  private final String typeName;
  /** the list of SensorTypes supported (ex: Temp, CO2) */
  private List<SensorType> sensors;

  /**
   * Constuctor - requires the typeName as an identifier
   * @param typeName
   */
  public DeviceType(String typeName)
  {
    this.typeName = typeName;
    this.sensors = new ArrayList<SensorType>();
  }

  /**
   * Add a SensorType to the list this DeviceType supports
   * @param sensorType
   */
  public void add(SensorType sensorType)
  {
    sensors.add(sensorType);
  }

  /**
   * Get the type identifer of this DeviceType
   * (e.g. "Firefly_V3")
   * @return the type as a String
   */
  public String getType()
  {
    return typeName;
  }

  /**
   * Get the list of SensorTypes
   * (e.g. "Temp", "CO2")
   * @return list of supported SensorTypes
   */
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
