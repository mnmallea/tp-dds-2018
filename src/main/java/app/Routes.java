package app;

import controllers.*;
import dominio.Cliente;
import exception.UnauthorizedException;
import handlebarsUtils.BooleanHelper;
import handlebarsUtils.EqualityHelper;
import handlebarsUtils.HandlebarsTemplateEngineBuilder;
import handlebarsUtils.IsNumberHelper;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class Routes {
    public static void configure() {
        HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .withHelper("isNumber", new IsNumberHelper())
                .withHelper("equals", new EqualityHelper())
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

        before("/reportes/*", LoginValidator::validateAdmin);
        get("/reportes/transformadores/consumos", TransformadoresController::show, engine);
        get("/reportes/usuarios", HogaresController::seleccionarDispositivos, engine);
        get("/reportes/usuarios/:id/promedios", DispositivosController::showConsumos, engine);
        get("/reportes/hogares/consumos", HogaresController::consumosPorPeriodo, engine);

        path("/administrador", () -> {
            before("", LoginValidator::validateAdmin);
            before("/*", LoginValidator::validateAdmin);

            get("", HomeController::show, engine);
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
                return ClienteController.consumos(request, cliente);
            }), engine);

            get("/consumos?", ((request, response) -> {
                Cliente cliente = (Cliente) LoginValidator.getUsuario(request);
                return ClienteController.consumos(request, cliente);
            }), engine);

        });

    }
}
