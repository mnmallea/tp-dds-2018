import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.post;

import controllers.AdministradorController;
import controllers.HomeController;
import controllers.LoginController;
import controllers.LoginValidator;
import handlebarsUtils.BooleanHelper;
import handlebarsUtils.HandlebarsTemplateEngineBuilder;
import repositorios.RepoTransformadores;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Routes {
    public static void configure() {
        HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();

        Spark.staticFiles.location("/public");

        get("/login", LoginController::show, engine);
        post("/login", LoginController::login);

        before("/", LoginValidator::validate);
        get("/", HomeController::show, engine);
        get("/administradores/:id/*", AdministradorController::show);
        get("/clientes/:id/*", (request, response) -> "<html> <body> <h1>" + RepoTransformadores.instancia.getTransformadores() + "</h1> </body> </html>");
        get("/logout", LoginValidator::removeAuthenticatedUser);
    }
}
