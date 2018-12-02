package controllers;

import dominio.Administrador;
import dominio.Cliente;
import dominio.TipoUsuario;
import dominio.Usuario;
import repositorios.RepoUsuarios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

import java.util.HashMap;

import static spark.Spark.halt;

public class LoginController {

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
            System.out.println("No existe el usuario ingresado");
            res.redirect("/login?invalid=true");
            halt();
        }

        if (PasswordUtil.verifyPassword(password, usuario.getHashedPassword()))
            System.out.println("La password esta bien"); // y corresponde a ese usuario, o sea aca ya esta perfectamente logueado
        else {
            System.out.println("Contraseña incorrecta");
            res.redirect("/login?invalid=true");
            halt();
        }

        TipoUsuario tipoUsuario = null;
        if (usuario instanceof Administrador) {
            tipoUsuario = TipoUsuario.ADMINISTRADOR;
        } else if (usuario instanceof Cliente) {
            tipoUsuario = TipoUsuario.CLIENTE;
        }

        System.out.println("CREANDO SESION");
        Session session = req.session(true);
        session.attribute(LoginValidator.USER_SESSION_ID, usuario.getId());
        session.attribute(LoginValidator.USER_TYPE, tipoUsuario);
        session.attribute(LoginValidator.USER_INSTANCE, usuario);
        System.out.println("--SESION--");

        res.redirect("/");
        return null;
    }
}
