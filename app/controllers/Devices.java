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
    }

    public static Result getDeviceTypeList() {
        List<DeviceType> deviceTypes = null;
        try {
            DeviceManager deviceManager = new DeviceManager();
            deviceTypes = deviceManager.getDeviceTypes();
        } catch (Exception e) {
            e.printStackTrace();
            return badRequest(e.getMessage());
        }
        return ok(views.html.deviceType.devicetypelist.render(deviceTypes));
    }

    public static Result getSensorTypes(String deviceType) {
        try {
            List<SensorType> sensorTypes = null;
            DeviceManager deviceManager = new DeviceManager();
            sensorTypes = deviceManager.getSensorTypes(deviceType);
//            return ok(views.html.sensorType.dropdown.render(sensorTypes));
            return ok();
        } catch (Exception e) {
            e.printStackTrace();
            return badRequest();
        }
    }

     public static Result getSensors() {
        List<Device> devices = null;
        try {
            DeviceManager deviceManager = new DeviceManager();
            devices = deviceManager.getDevices();
        } catch (Exception e) {
            e.printStackTrace();
            return badRequest(e.getMessage());
        }
        return ok(views.html.devices.sensorlist.render(devices));
    }

    public static Result getDevices() {
        List<Device> devices = null;
        try {
            DeviceManager deviceManager = new DeviceManager();
            devices = deviceManager.getDevices();
        } catch (Exception e) {
            e.printStackTrace();
            return badRequest(e.getMessage());
        }
        return ok(views.html.devices.devicelist.render(devices));
    }

    public static Result getDeviceAgents() {
    List<String> deviceAgents = null;
        try {
            DeviceManager deviceManager = new DeviceManager();
            deviceAgents = deviceManager.getDeviceAgents();
        } catch (Exception e) {
            e.printStackTrace();
            return badRequest(e.getMessage());
        }
        return ok(views.html.devices.deviceagentlist.render(deviceAgents));
    }

    public static Result getAllSensorTypes() {
    List<String> sensorTypes = null;
    try {
            DeviceManager deviceManager = new DeviceManager();
            sensorTypes = deviceManager.getAllSensorTypes();
        } catch (Exception e) {
            e.printStackTrace();
            return badRequest(e.getMessage());
        }
        return ok(views.html.sensorType.sensortypelist.render(sensorTypes));
    }
}
