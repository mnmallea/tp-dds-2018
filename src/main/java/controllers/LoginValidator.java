package controllers;

import dominio.TipoUsuario;
import dominio.Usuario;
import exception.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

import static spark.Spark.halt;

public class LoginValidator {
    private static final Logger logger = LoggerFactory.getLogger(LoginValidator.class);

    public static final String USER_SESSION_ID = "user_id";
    public static final String USER_TYPE = "user_type";
    public static final String USER_INSTANCE = "user_instance";

    public static void validate(Request request, Response response) {
        Long user = getAuthenticatedUser(request);
        if (user == null) {
            logger.info("Usuario no ha iniciado sesion");
            response.redirect("/login");
            halt();
        }
    }

    public static Long getAuthenticatedUser(Request request) {
        return request.session().attribute(USER_SESSION_ID);
    }

    public static void addAuthenticatedUser(Request request, String u) {
        request.session().attribute(USER_SESSION_ID, u);
    }

    public static Void removeAuthenticatedUser(Request request, Response response) {
        request.session().removeAttribute(USER_SESSION_ID);
        response.redirect("/");
        return null;
    }

    public static void validateAdmin(Request request, Response response) {
        validate(request, response);
        if (!esUsuarioDeTipo(request, TipoUsuario.ADMINISTRADOR)) {
            throw new UnauthorizedException();
        }
    }

    public static boolean esUsuarioDeTipo(Request request, TipoUsuario tipoUsuario) {
        return request.session().attribute(USER_TYPE) == tipoUsuario;
    }


    public static void validateCliente(Request request, Response response) {
        validate(request, response);
        if (!esUsuarioDeTipo(request, TipoUsuario.CLIENTE)) {
            throw new UnauthorizedException();
        }
    }

    public static Usuario getUsuario(Request request) {
        return request.session().attribute(USER_INSTANCE);
    }
}
