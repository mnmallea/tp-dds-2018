package controllers;

import dominio.TipoUsuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import static spark.Spark.halt;

public class HomeController {

    public static ModelAndView show(Request req, Response res) {
        if (LoginValidator.esUsuarioDeTipo(req, TipoUsuario.CLIENTE)) {
            Long userId = LoginValidator.getAuthenticatedUser(req);
            res.redirect("/clientes/" + userId + "/hogar");
            halt();
        }
        if (LoginValidator.esUsuarioDeTipo(req, TipoUsuario.ADMINISTRADOR)) {
            res.redirect("/administrador/hogares");
            halt();
        }
        throw new RuntimeException();
    }

}
