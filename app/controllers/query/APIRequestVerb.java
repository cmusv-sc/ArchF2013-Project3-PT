package controllers.query;

/**
 * Enum to hold mappings to Restful API verbs
 * @author geoffschaeffer
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
   GET_SENSOR_READING("sensors");
   
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
