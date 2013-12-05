package controllers;

import play.Routes;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import views.html.dashboard;
import views.html.deviceagents;
import views.html.devicelist;
import views.html.devicetypes;
import views.html.index;
import views.html.sensors;
import views.html.sensortypes;

/**
 * Main Play controller class for routing and serving pages
 * 
 * @author Team Mercury
 */
public class Application extends Controller
{
   /**
    * Render the index page
    * @return Result
    */
   public static Result index()
   {
      return ok(index.render());
   }

   /**
    * Render the sensors page
    * @return Result
    */
   public static Result sensors()
   {
      return ok(sensors.render());
   }

   /**
    * Javascript routes for AJAX operations. Reference:
    * http://www.playframework.com/documentation/2.2.x/JavaGuide6
    * @return Result
    */
   public static Result javascriptRoutes()
   {
      response().setContentType("text/javascript");
      return ok(Routes.javascriptRouter("jsRoutes",
            routes.javascript.Devices.getAllSensorTypes(),
            routes.javascript.Devices.getDeviceAgents(),
            routes.javascript.Devices.getDevices(),
            routes.javascript.Devices.getDeviceTypes(),
            routes.javascript.Devices.getDeviceTypeList(),
            routes.javascript.Devices.getSensors(),
            routes.javascript.Devices.getSensorTypes(),
            routes.javascript.Dashboard.getSensorTypesAndDeviceId(),
            routes.javascript.Dashboard.getReading()));
   }

   /**
    * Render the dashboard page
    * @return Result
    */
   public static Result dashboard()
   {
      return Results.ok(dashboard.render());
   }

   /**
    * Render the devices page
    * @return Result
    */
   public static Result devices()
   {
      return Results.ok(devicelist.render());
   }

   /**
    * Render the deviceAgents page
    * @return Result
    */
   public static Result deviceAgents()
   {
      return Results.ok(deviceagents.render());
   }

   /**
    * Render the sensorTypes page
    * @return Result
    */
   public static Result sensorTypes()
   {
      return Results.ok(sensortypes.render());
   }

   /**
    * Render the deviceTypes page
    * @return Result
    */
   public static Result deviceTypes()
   {
      return Results.ok(devicetypes.render());
   }
}
