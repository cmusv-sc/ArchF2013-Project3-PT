package controllers;

import java.util.List;

import models.Device;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.F.*;
import play.libs.WS;
import play.mvc.*;

import views.html.index;

public class Application extends Controller {

//    private static final String URL = "http://einstein.sv.cmu.edu/sensors/10170102/1368568896000/temp/json";
    private static final String URL = "http://einstein.sv.cmu.edu/sensors";

    public static Result index() {
        return ok(index.render());
    }

    /*public static Promise<Result> index() {

        Promise<WS.Response> response = WS.url(URL).get();
        return response.map(new Function<WS.Response, Result>() {
            @Override
            public Result apply(WS.Response resp) throws Throwable {
                return (Result) ok(resp.asJson());
            }
        });
    }*/

    public static Promise<Result> sensors() {
        DynamicForm requestData = Form.form().bindFromRequest();
        String id = requestData.get("id");
        String sensorType = requestData.get("sensorType");
        String timestamp = requestData.get("timestamp");
        String reportType = requestData.get("reportType");

        String requestURL = new StringBuilder()
                .append(URL).append("/")
                .append(id).append("/")
                .append(timestamp).append("/")
                .append(sensorType).append("/")
                .append(reportType).toString();

        System.out.println(requestURL); //Testing

        Promise<WS.Response> response = WS.url(requestURL).get();
        return response.map(new Function<WS.Response, Result>() {
            @Override
            public Result apply(WS.Response resp) throws Throwable {
//                System.out.println(resp.asJson());
//                return ok(index.render("Results: " + resp.asJson()));
                return ok();
            }
        });

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
                    routes.javascript.Devices.getSensorTypes()
            )
        );
    }



}
