package app;

import static spark.Spark.before;
import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

import controllers.DispositivosController;
import controllers.HogaresController;
import controllers.HomeController;
import controllers.LoginController;
import controllers.LoginValidator;
import controllers.TransformadoresController;
import dominio.Administrador;
import dominio.Cliente;
import exception.UnauthorizedException;
import handlebarsUtils.BooleanHelper;
import handlebarsUtils.EqualityHelper;
import handlebarsUtils.HandlebarsTemplateEngineBuilder;
import handlebarsUtils.IsNumberHelper;
import repositorios.RepoTransformadores;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

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

        //get("/administradores/:id/*", AdministradorController::show);
        get("/clientes/:id/*", (request, response) -> "<html> <body> <h1>" + RepoTransformadores.instancia.getTransformadores() + "</h1> </body> </html>");
    }
}
