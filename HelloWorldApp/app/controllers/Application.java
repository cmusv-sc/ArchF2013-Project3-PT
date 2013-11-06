package controllers;

import play.*;
import play.libs.F.*;
import play.libs.WS;
import play.mvc.*;

import views.html.*;
import views.html.index;

public class Application extends Controller {

    private static final String URL = "http://einstein.sv.cmu.edu/sensors/10170102/1368568896000/temp/json";

    /*public static Result index() {
        return ok(index.render("Dear World, Team Mercury says Hello!"));
    }*/

    public static Promise<Result> index() {
        Promise<WS.Response> response = WS.url(URL).get();
        return response.map(new Function<WS.Response, Result>() {
            @Override
            public Result apply(WS.Response resp) throws Throwable {
                return (Result) ok(resp.asJson());
            }
        });
    }



}
