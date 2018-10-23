import controllers.HomeController;
import controllers.LoginController;
import controllers.LoginValidator;
import exception.UnloggedException;
import handlebarsUtils.BooleanHelper;
import handlebarsUtils.HandlebarsTemplateEngineBuilder;
import repositorios.RepoTransformadores;
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

        Spark.staticFiles.location("/public");

        get("/login", LoginController::show, engine);
        post("/login", LoginController::login);

        before("/", LoginValidator::validate);
        get("/", HomeController::show, engine);
        before("/transformadores", LoginValidator::validate);
        get("/transformadores", (request, response) -> "<html> <body> <h1>" + RepoTransformadores.instancia.getTransformadores() + "</h1> </body> </html>");
        get("/logout", LoginValidator::removeAuthenticatedUser);
    }
}
