package controllers;

import dominio.TipoUsuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class HomeController {

    public static ModelAndView show(Request req, Response res) {
        if (LoginValidator.esUsuarioDeTipo(req, TipoUsuario.CLIENTE))
            return new ModelAndView(null, "home/home.hbs");
        if(LoginValidator.esUsuarioDeTipo(req, TipoUsuario.ADMINISTRADOR))
            return new ModelAndView(null, "administrador/reportes/dispositivos.hbs");
        throw new RuntimeException();
    }

}
