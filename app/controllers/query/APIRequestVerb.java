package controllers.query;

public enum APIRequestVerb
{
   GET_ALL_DEVICES("get_devices"),
   GET_SENSOR_TYPES("get_sensor_types"),
   GET_SENSOR_READING("sensors");
   
   private final String verbString;
   
   APIRequestVerb(String _verbString)
   {
      verbString = _verbString;
   }
   
   public String getVerbString()
   {
      return verbString;
   }
}
