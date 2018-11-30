package app;

import controllers.*;
import dominio.Administrador;
import dominio.Cliente;
import exception.UnauthorizedException;
import handlebarsUtils.BooleanHelper;
import handlebarsUtils.EqualityHelper;
import handlebarsUtils.HandlebarsTemplateEngineBuilder;
import handlebarsUtils.IsNumberHelper;
import spark.ModelAndView;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class Routes {
    public static void configure() {
        HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();

        staticFiles.location("/public");

        exception(UnauthorizedException.class, ((exception, request, response) -> {
            ModelAndView modelAndView = new ModelAndView(null, "errors/unauthorized.hbs");
            String render = engine.render(modelAndView);
            response.body(render);
            response.status(401);
        }));

        before("/", LoginValidator::validate);
        get("/", HomeController::show, engine);
        get("/login", LoginController::show, engine);
        post("/login", LoginController::login);
        get("/logout", LoginValidator::removeAuthenticatedUser);

        path("/administrador", () -> {
            before("", LoginValidator::validateAdmin);
            before("/*", LoginValidator::validateAdmin);
            get("", ((request, response) -> {
                Administrador administrador = (Administrador) LoginValidator.getUsuario(request);
                return "Logeaste como un administrador: " + administrador.getNombre() + "  Fecha de alta: " + administrador.getFechaAlta();
            }));
            get("/hogares", HogaresController::show, engine);
        });

        path("/cliente", () -> {
            before("", LoginValidator::validateCliente);
            before("/*", LoginValidator::validateCliente);
            get("", ((request, response) -> {
                Cliente cliente = (Cliente) LoginValidator.getUsuario(request);
                return "Logeaste como un cliente:" + cliente.getNombre() + "!!!  Vivis en: " + cliente.getDireccion();
            }));
        });

        get("/administradores/:id/*", AdministradorController::show);
        get("/clientes/:id/*", (request, response) -> "<html> <body> <h1>" + RepoTransformadores.instancia.getTransformadores() + "</h1> </body> </html>");
    }
}
