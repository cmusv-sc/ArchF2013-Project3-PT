package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.DeviceType;
import models.SensorReading;
import models.SensorType;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

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
     * @return
     */
    public static Result getReading() {
        DeviceManager deviceManager = new DeviceManager();
        DynamicForm formData = Form.form().bindFromRequest();

        Map<String, String> parameters = toMap(formData);

        List<SensorReading> sensorReadings = deviceManager.getSensorReadings(parameters);
        if(sensorReadings.isEmpty()) {
            return notFound("No data found");
        } else {
            ObjectNode data = Json.newObject();
            for (SensorReading sensorReading : sensorReadings) {
                ObjectNode reading = Json.newObject();
                reading.put("x", sensorReading.getTimestamp());
                reading.put("y", sensorReading.getValue());
                data.put(reading);
            }
        }
        return play.mvc.Results.ok(views.html.sensorReading.chart.render(sensorReadings));
    }

    /**
     * private helper for generating parameter map from dynamic form.
     * @param formData
     * @return {@link Map<String,String>} parameters
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
