package models.query;

import static org.junit.Assert.*;

import models.query.mock.MockQueryRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Contains unit tests for QueryRequest class
 * 
 * Since QueryRequest is the public class that is the main
 * access-point for the query package, tests of this class 
 * will exercise the other classes in the query package as well
 * 
 * Use a Mock of QueryRequest to insulate tests from unreliable
 * API
 * 
 * @author Team Mercury
 */
@RunWith(JUnit4.class)
public class QueryRequestTest
{   
   /**
    * Test of getAllDevices in QueryRequest
    */
   @Test
   public void getAllDevicesTest()
   {
      IQueryRequest req = new MockQueryRequest();
      QueryResponse resp = req.getAllDevices();

      assertTrue(responseContainsKeyValue(resp, DEVICE_TYPE_TAG, FIREFLY));
      assertTrue(responseContainsKeyValue(resp, DEVICE_LOCATION_TAG, DEVICE_LOCATION_VALUE));
      assertTrue(responseContainsKeyValue(resp, DEVICE_AGENT_TAG, DEVICE_AGENT_VALUE));
      assertTrue(responseContainsKeyValue(resp, URI_TAG, URI_VALUE));
   }
   
   /**
    * test helper - checks if a QueryResponse contains
    * the value
    * @param resp
    * @param value
    * @return if response contains value
    */
   private boolean responseContainsKeyValue(QueryResponse resp, String key, String value)
   {
      boolean contains = false;
      
      for(ResponseComponent currComp: resp) 
      {
         CompositeComponent compNode = (CompositeComponent) currComp;
         String checkVal = compNode.getValueAsString(key);
         if(checkVal != null)
         {
            if(checkVal.equals(value))
            {
               contains = true;
               break;
            }            
         }
      }
      
      return contains;
   }
   
   /**
    * Test of getAllDevices in QueryRequest
    */
   @Test
   public void getSensorTypesTest()
   {
      IQueryRequest req = new MockQueryRequest();
      
      QueryDeviceArg dArg = new QueryDeviceArg(FIREFLY);
      QueryResponse resp = req.getSensorTypes(dArg);

      assertTrue(responseContainsKeyValue(resp, DEVICE_TYPE_TAG, FIREFLY));
      assertTrue(responseContainsKeyValue(resp, SENSOR_TYPE_TAG, SENSOR_TYPE_VALUE));
   }
   
   /**
    * Test of getSensorReadingByTimePoint in QueryRequest
    */
   @Test
   public void getSensorReadingByTimePointTest()
   {
      IQueryRequest req = new MockQueryRequest();
      
      QueryDeviceArg dArg = new QueryDeviceArg("10170102");
      QuerySensorTypeArg sArg = new QuerySensorTypeArg("temp");
      QueryTimeArg tArg = new QueryTimeArg("1368568896000");
      QueryResponse resp = req.getSensorReadingByTimePoint(dArg, sArg, tArg);
      
      assertTrue(responseContainsKeyValue(resp, SENSOR_TYPE_TAG, SENSOR_TYPE_TEMP_VALUE));
      assertTrue(responseContainsKeyValue(resp, TIMESTAMP_TAG, TIMESTAMP_6000_VALUE));
      assertTrue(responseContainsKeyValue(resp, VALUE_TAG, VALUE_VALUE));
      assertTrue(responseContainsKeyValue(resp, DEVICE_ID_TAG, DEVICE_ID_VALUE));
   }
   
   /**
    * Test of getSensorReadingByTimeRange in QueryRequest
    */
   @Test
   public void getSensorReadingByTimeRangeTest()
   {
      IQueryRequest req = new MockQueryRequest();
      
      QueryDeviceArg dArg = new QueryDeviceArg("10170102");
      QuerySensorTypeArg sArg = new QuerySensorTypeArg("temp");
      QueryTimeArg tArg = new QueryTimeArg("1368568896000");
      QueryTimeArg t2Arg = new QueryTimeArg("1368568896000");
      QueryResponse resp = req.getSensorReadingByTimeRange(dArg, sArg, tArg, t2Arg);
      
      assertTrue(responseContainsKeyValue(resp, SENSOR_TYPE_TAG, SENSOR_TYPE_TEMP_VALUE));
      assertTrue(responseContainsKeyValue(resp, TIMESTAMP_TAG, TIMESTAMP_3000_VALUE));
      assertTrue(responseContainsKeyValue(resp, VALUE_TAG, VALUE_VALUE));
      assertTrue(responseContainsKeyValue(resp, DEVICE_ID_TAG, DEVICE_ID_VALUE));
   }
   
   /**
    * Test of getLastReadings in QueryRequest
    */
   @Test
   public void getLastReadingsTest()
   {
      IQueryRequest req = new MockQueryRequest();
      
      QuerySensorTypeArg sArg = new QuerySensorTypeArg("temp");
      QueryTimeArg tArg = new QueryTimeArg("1368568896000");
      QueryResponse resp = req.getLastReadings(sArg, tArg);
      
      assertTrue(responseContainsKeyValue(resp, SENSOR_TYPE_TAG, SENSOR_TYPE_TEMP_VALUE));
      assertTrue(responseContainsKeyValue(resp, TIMESTAMP_TAG, TIMESTAMP_6000_VALUE));
      assertTrue(responseContainsKeyValue(resp, VALUE_TAG, VALUE_VALUE));
      assertTrue(responseContainsKeyValue(resp, DEVICE_ID_TAG, DEVICE_ID_VALUE));
   }
   
   /**
    * Test of getLastReadings in QueryRequest
    */
   @Test
   public void getLastestReadingsTest()
   {
      IQueryRequest req = new MockQueryRequest();
      
      QuerySensorTypeArg sArg = new QuerySensorTypeArg("temp");
      QueryResponse resp = req.getLastestReadings(sArg);
      
      assertTrue(responseContainsKeyValue(resp, SENSOR_TYPE_TAG, SENSOR_TYPE_TEMP_VALUE));
      assertTrue(responseContainsKeyValue(resp, TIMESTAMP_TAG, TIMESTAMP_6000_VALUE));
      assertTrue(responseContainsKeyValue(resp, VALUE_TAG, VALUE_VALUE));
      assertTrue(responseContainsKeyValue(resp, DEVICE_ID_TAG, DEVICE_ID_VALUE));
   }
   
   private static final String DEVICE_TYPE_TAG = "device_type";
   private static final String FIREFLY = "Firefly_v3";
   
   private static final String DEVICE_LOCATION_TAG = "device_location";
   private static final String DEVICE_LOCATION_VALUE = "B23.216";
   
   private static final String DEVICE_AGENT_TAG = "device_agent";
   private static final String DEVICE_AGENT_VALUE = "SensorAndrew2";
   
   private static final String URI_TAG = "uri";
   private static final String URI_VALUE = "10170202";
   
   private static final String SENSOR_TYPE_TAG = "sensor_type";   
   private static final String SENSOR_TYPE_VALUE = "temp,digital_temp,light,pressure,humidity,motion,audio_p2p,acc_x,acc_y,acc_z";
   private static final String SENSOR_TYPE_TEMP_VALUE = "temp";  
   
   private static final String TIMESTAMP_TAG = "timestamp";
   private static final String TIMESTAMP_6000_VALUE = "1368568896000";
   private static final String TIMESTAMP_3000_VALUE = "1368568993000";
   
   private static final String VALUE_TAG = "value";
   private static final String VALUE_VALUE = "518";
   
   private static final String DEVICE_ID_TAG = "device_id";
   private static final String DEVICE_ID_VALUE = "10170102";
   
}
