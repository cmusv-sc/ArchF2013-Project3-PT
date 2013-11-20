package models;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SensorType
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

    public static Set<SensorType> parseSensorTypeList(final String sensorTypeTokens) {
        Set<SensorType> sensorTypes = new HashSet<SensorType>();
        if (sensorTypeTokens != null && !sensorTypeTokens.isEmpty()) {
            StringTokenizer tokenizer = new StringTokenizer(sensorTypeTokens, ",");
            while (tokenizer.hasMoreElements()) {
                sensorTypes.add(new SensorType(tokenizer.nextToken()));
            }
        }
        return sensorTypes;
    }
}
