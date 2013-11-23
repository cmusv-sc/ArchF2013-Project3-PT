package controllers;

import models.DeviceType;
import models.SensorType;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.dashboard;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: atrivedi@apple.com
 * Date: 11/23/13
 * Time: 1:42 PM
 */
public class Dashboard extends Controller {

    public static Result getSensorTypesAndDeviceId(String deviceType) {
        DeviceManager deviceManager = new DeviceManager();
        List<String> deviceIds = deviceManager.getDeviceIds(new DeviceType(deviceType));
        List<SensorType> sensorTypes = deviceManager.getSensorTypes(deviceType);
        return ok(views.html.metadata.sensorTypes.render(sensorTypes, deviceIds));
    }
}
