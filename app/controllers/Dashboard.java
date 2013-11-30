package controllers;

import models.DeviceType;
import models.SensorType;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

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
}
