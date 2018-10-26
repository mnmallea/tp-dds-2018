import controllers.*;
import dominio.Administrador;
import dominio.Cliente;
import exception.UnauthorizedException;
import handlebarsUtils.BooleanHelper;
import handlebarsUtils.HandlebarsTemplateEngineBuilder;
import repositorios.RepoTransformadores;
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

        path("/clientes/:id", () -> {
            before("", LoginValidator::validateCliente);
            before("/*", LoginValidator::validateCliente);
            get("/hogar", ((request, response) -> {
                Cliente cliente = (Cliente) LoginValidator.getUsuario(request);
                return ClienteController.home(cliente);
            }), engine);

            get("/consumos", ((request, response) -> {
                Cliente cliente = (Cliente) LoginValidator.getUsuario(request);
                return ClienteController.home(cliente);
            }), engine);

            get("/simplex", ((request, response) -> {
                Cliente cliente = (Cliente) LoginValidator.getUsuario(request);
                return ClienteController.simplex(cliente);
            }), engine);
        });

    }
}
