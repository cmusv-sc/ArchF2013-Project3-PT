package controllers;

import models.Device;
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

    public static Result index() {
        List<Device> devices = null;
        try {
            DeviceManager deviceManager = new DeviceManager();
            devices = deviceManager.getDevices();
        } catch (Exception e) {
            return ok(e.getMessage());
        }
        return ok(views.html.device.dropdown.render(devices));
//        return ok("hello");
    }
}
