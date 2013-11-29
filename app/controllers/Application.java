package controllers;

import java.util.List;

import models.Device;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.F.*;
import play.libs.WS;
import play.mvc.*;

import views.html.dashboard;
import views.html.devicelist;
import views.html.index;
import views.html.sensors;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }
    
    public static Result sensors() {
      return ok(sensors.render());
    }

    /**
     * Javascript routes for AJAX operations.
     * Reference: http://www.playframework.com/documentation/2.2.x/JavaGuide6
     */
    public static Result javascriptRoutes() {
        response().setContentType("text/javascript");
        return ok(
            Routes.javascriptRouter("jsRoutes",
                    routes.javascript.Devices.getDeviceTypes(),
                    routes.javascript.Devices.getSensorTypes(),
                    routes.javascript.Devices.getDevices(),
                    routes.javascript.Dashboard.getSensorTypesAndDeviceId()
            )
        );
    }


    public static Result dashboard() {
        return Results.ok(dashboard.render());
    }

    public static Result devices() {
        return Results.ok(devicelist.render());
    }
}
