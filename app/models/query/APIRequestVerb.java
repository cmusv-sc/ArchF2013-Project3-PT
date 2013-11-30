package models.query;

/**
 * Enum to hold mappings to Restful API verbs
 * @author Team Mercury
 */
enum APIRequestVerb
{
   /** for Category3 API 
    * https://github.com/SensorServicePlatform/APIs#1 
    */
   GET_ALL_DEVICES("get_devices"),
   /** for Category3 API 
    * https://github.com/SensorServicePlatform/APIs#2 
    */
   GET_SENSOR_TYPES("get_sensor_types"),
   /** for Category2 API 
    * https://github.com/SensorServicePlatform/APIs#4 
    * https://github.com/SensorServicePlatform/APIs#5
    * https://github.com/SensorServicePlatform/APIs#20 
    * https://github.com/SensorServicePlatform/APIs#21
    */
   GET_SENSOR_READING("sensors"),
   /** for Category2 API 
    * https://github.com/SensorServicePlatform/APIs#6
    */
   GET_LAST_READINGS("last_readings_from_all_devices"),
   /** for Category2 API 
    * https://github.com/SensorServicePlatform/APIs#7
    * These readings are the most last
    */
   GET_LASTEST_READINGS("lastest_readings_from_all_devices");
   
   
   private final String verbString;
   
   APIRequestVerb(String _verbString)
   {
      verbString = _verbString;
   }
   
   /**
    * Get the enum as string for use in API
    * @return enum value as API string
    */
   protected String getVerbString()
   {
      return verbString;
   }
}
