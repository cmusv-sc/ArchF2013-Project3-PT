package controllers;

import models.Device;
import models.DeviceType;
import models.SensorType;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: atrivedi@apple.com
 * Date: 11/19/13
 * Time: 12:14 PM
 */
public class Devices extends Controller {
    public static Result getDeviceTypes() {
        List<DeviceType> deviceTypes = null;
        try {
            DeviceManager deviceManager = new DeviceManager();
            deviceTypes = deviceManager.getDeviceTypes();
        } catch (Exception e) {
            e.printStackTrace();
            return badRequest(e.getMessage());
        }
        return ok(views.html.deviceType.dropdown.render(deviceTypes));
//        return ok("hello");
    }

    public static Result getSensorTypes(String deviceType) {
        try {
            List<SensorType> sensorTypes = null;
            DeviceManager deviceManager = new DeviceManager();
            sensorTypes = deviceManager.getSensorTypes(deviceType);
            return ok(views.html.sensorType.dropdown.render(sensorTypes));
        } catch (Exception e) {
            e.printStackTrace();
            return badRequest();
        }
    }
}
