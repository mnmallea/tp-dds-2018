package controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class AdministradorController {
	
	public static ModelAndView show(Request req, Response res){
        return new ModelAndView(null, "home/holis.hbs");
    }

}
