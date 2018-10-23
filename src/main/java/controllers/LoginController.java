package controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class LoginController {


    public static ModelAndView show(Request req, Response res){
        return new ModelAndView(null, "home/login.hbs");
    }

    public static ModelAndView login(Request req, Response res) {
        String username = req.queryParams("username");
        String password = req.queryParams("password");
        /*
        Hace el hash md5 y valida como la gente que esté to do piola
         */
        req.session().attribute(LoginValidator.USER_SESSION_ID, username);
        res.redirect("/");
        return null;
    }


}