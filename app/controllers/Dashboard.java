package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.DeviceType;
import models.SensorReading;
import models.SensorType;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Dashboard page controller
 * 
 * @author Team Mercury
 */
public class Dashboard extends Controller
{
   /**
    * Helper for rendering SensorTypes and DeviceIds based on DeviceType
    * @param deviceType
    * @return Result
    */
   public static Result getSensorTypesAndDeviceId(String deviceType)
   {
      DeviceManager deviceManager = new DeviceManager();
      List<String> deviceIds = deviceManager.getDeviceIds(new DeviceType(
            deviceType));
      List<SensorType> sensorTypes = deviceManager.getSensorTypes(deviceType);
      return ok(views.html.metadata.sensorTypes.render(sensorTypes, deviceIds));
   }

    /**
     * GET /readings.json
     * @return Result
     */
    public static Result getReading() {
        DeviceManager deviceManager = new DeviceManager();
        DynamicForm formData = Form.form().bindFromRequest();

        Map<String, String> parameters = toMap(formData);

        List<SensorReading> sensorReadings = deviceManager.getSensorReadings(parameters);
        if(sensorReadings.isEmpty()) {
            return notFound("No data found");
        } else {
            List<ObjectNode> data = new ArrayList<ObjectNode>();
//            JsonNode data = Json.toJson(sensorReadings);
            for (SensorReading sensorReading : sensorReadings) {
                ObjectNode reading = Json.newObject();
                reading.put("x", Long.parseLong(sensorReading.getTimestamp()));
                reading.put("y", Long.parseLong(sensorReading.getValue()));
                data.add(reading);
            }
            String jsonData = Json.toJson(data).toString();
            Logger.info("Json: " + jsonData);
            return ok(jsonData);
        }

        //Testing charts
//        String dummyData = "{ \"x\": -1893456000, 'y': 92228531 }, { 'x': -1577923200, 'y': 106021568 }, { 'x': -1262304000, 'y': 123202660 }, { 'x': -946771200, 'y': 132165129 }, { 'x': -631152000, 'y': 151325798 }, { 'x': -315619200, 'y': 179323175 }, { 'x': 0, 'y': 203211926 }, { 'x': 315532800, 'y': 226545805 }, { 'x': 631152000, 'y': 248709873 }, { 'x': 946684800, 'y': 281421906 }, { 'x': 1262304000, 'y': 308745538 }";
//        return ok(dummyData);
    }

    /**
     * private helper for generating parameter map from dynamic form.
     * @param formData
     * @return @link Map<String,String>} parameters
     */
    private static Map<String, String> toMap(DynamicForm formData) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put(DeviceManager.QUERY_TYPE, DeviceManager.TIMEFRAME_READINGS);
        parameters.put(DeviceManager.DEVICE_ID, formData.get(DeviceManager.DEVICE_ID));
        parameters.put(DeviceManager.SENSOR_TYPE, formData.get(DeviceManager.SENSOR_TYPE));
        parameters.put(DeviceManager.START_TIME, formData.get(DeviceManager.START_TIME));
        parameters.put(DeviceManager.END_TIME, formData.get(DeviceManager.END_TIME));
        return parameters;
    }
}
