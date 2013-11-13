package controllers;

import java.util.List;

public class QueryRequest 
{
   public List<QueryResponse> getAllDevices()
   {
       /* impl of Category 3 API - get all devices */
	   return null;
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
}
