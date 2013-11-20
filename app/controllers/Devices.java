package controllers;

import models.Device;
import models.DeviceType;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

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
            return badRequest(e.getMessage());
        }
        return ok(views.html.device.dropdown.render(deviceTypes));
//        return ok("hello");
    }
}
