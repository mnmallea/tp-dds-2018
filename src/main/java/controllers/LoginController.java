package controllers;

import dominio.Administrador;
import dominio.Cliente;
import dominio.TipoUsuario;
import dominio.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repositorios.RepoUsuarios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

import java.util.HashMap;

import static spark.Spark.halt;

public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @SuppressWarnings("unchecked")
    public static ModelAndView show(Request req, Response res) {
        String invalid = req.queryParams("invalid");
        HashMap<String, Object> viewModel = new HashMap();
        viewModel.put("invalid", "true".equals(invalid));
        return new ModelAndView(viewModel, "home/login.hbs");
    }

    public static ModelAndView login(Request req, Response res) {

        String usernameReq = req.queryParams("username");
        String password = req.queryParams("password");

        Usuario usuario = RepoUsuarios.instancia.findUsuarioByUsername(usernameReq);

        if (usuario == null) {
            logger.warn("No existe el usuario ingresado");
            res.redirect("/login?invalid=true");
            halt();
        }

        if (PasswordUtil.verifyPassword(password, usuario.getHashedPassword()))
            logger.info("La password esta bien"); // y corresponde a ese usuario, o sea aca ya esta perfectamente logueado
        else {
            logger.warn("Contraseña incorrecta");
            res.redirect("/login?invalid=true");
            halt();
        }

        TipoUsuario tipoUsuario = null;
        if (usuario instanceof Administrador) {
            tipoUsuario = TipoUsuario.ADMINISTRADOR;
        } else if (usuario instanceof Cliente) {
            tipoUsuario = TipoUsuario.CLIENTE;
        }

        logger.debug("CREANDO SESION");
        Session session = req.session(true);
        session.attribute(LoginValidator.USER_SESSION_ID, usuario.getId());
        session.attribute(LoginValidator.USER_TYPE, tipoUsuario);
        session.attribute(LoginValidator.USER_INSTANCE, usuario);
        logger.debug("--SESION--");

        res.redirect("/");
        return null;
    }
}
