import repositorios.RepoTransformadores;

import static spark.Spark.get;

public class Routes {
    public static void configure() {
        get("/", (request, response) -> "<html> <body> <h1> <a href=\"/transformadores\">Transformadores</a> </h1> </body> </html>");
        get("/transformadores", (request, response) -> "<html> <body> <h1>" + RepoTransformadores.instancia.getTransformadores() + "</h1> </body> </html>");
    }
}
