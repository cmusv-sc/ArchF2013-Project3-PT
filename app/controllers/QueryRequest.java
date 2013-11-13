package controllers;

import java.util.List;

import play.libs.WS;
import play.libs.F.Function;
import play.libs.F.Promise;
import play.mvc.Result;
import views.html.index;

public class QueryRequest 
{
   public List<QueryResponse> getAllDevices()
   {
	   List<QueryResponse> retVal = null;
	   
       //impl of Category 3 API - get all devices
	   //this could be replaced with a builder for Requests
       String requestURL = SITE_URL + URL_SEP + GET_ALL_DEVICES + URL_SEP
    		               + JSON_RESPONSE_TYPE;
       
       //go synchronus for ease of impl
       WS.Response response = WS.url(requestURL).get().get(DEFAULT_TIMEOUT);
       retVal = JsonParser.toResponseList(response.asJson());
       
	   return retVal;
   }

   public QueryResponse getSensorTypes(DeviceType dType)
   {
       /* impl of Category 3 API */
	   return null;
   }

   public QueryResponse getSensorReadingByTime(Device device, 
                                               String sensorType,
                                               TimeArg timeframe)
   {
      /* impl of time-based sensor reading requests */
      return null;
   }
   
   //--------------------------------------------------------------------------
   
   private static long DEFAULT_TIMEOUT = 5000;
   private static final String SITE_URL = "http://einstein.sv.cmu.edu";
   private static final String URL_SEP = "/";
   private static final String JSON_RESPONSE_TYPE = "json";
   private static final String GET_ALL_DEVICES = "get_devices";
   private static final String GET_SENSOR_TYPES = "get_sensor_type";
   private static final String GET_SENSOR_READING = "sensors";
}
