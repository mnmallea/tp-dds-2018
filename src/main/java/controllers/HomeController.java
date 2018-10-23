package controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class HomeController extends BaseController{

    public static ModelAndView show(Request req, Response res) {
        instancia.loginValidation(req);
        return new ModelAndView(null, "home/home.hbs");
    }

}
