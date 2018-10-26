package controllers;

import dominio.Administrador;
import dominio.Cliente;
import dominio.TipoUsuario;
import dominio.Usuario;
import repositorios.RepoUsuarios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class LoginController {

    @SuppressWarnings("unchecked")
    public static ModelAndView show(Request req, Response res) {
        String invalid = req.queryParams("invalid");
        HashMap<String, Object> viewModel = new HashMap();
        viewModel.put("invalid", "true".equals(invalid));
        return new ModelAndView(viewModel, "home/login.hbs");
    }

    // tengo dudas sobre el noSuchAlgorithmException pero no me deja no ponerlo
    public static ModelAndView login(Request req, Response res) throws NoSuchAlgorithmException {

        String usernameReq = req.queryParams("username");
        String password = req.queryParams("password");

        Usuario usuario = RepoUsuarios.instancia.findUsuarioByUsername(usernameReq);

        if (usuario == null) {
            System.out.println("No existe el usuario ingresado");
            res.redirect("/login?invalid=true");
        }

        if (PasswordUtil.verifyPassword(password, usuario.getHashedPassword()))
            System.out.println("La password esta bien"); // y corresponde a ese usuario, o sea aca ya esta perfectamente logueado
        else {
            System.out.println("Contraseña incorrecta");
            res.redirect("/login?invalid=true");
        }

        TipoUsuario tipoUsuario = null;
        if (usuario instanceof Administrador) {
            res.redirect("/administrador");
            tipoUsuario = TipoUsuario.ADMINISTRADOR;
        } else if (usuario instanceof Cliente) {
            res.redirect("/clientes/" + usuario.getId() + "/hogar");
            tipoUsuario = TipoUsuario.CLIENTE;
        }


        req.session().attribute(LoginValidator.USER_SESSION_ID, usuario.getId());
        req.session().attribute(LoginValidator.USER_TYPE, tipoUsuario);
        req.session().attribute(LoginValidator.USER_INSTANCE, usuario);

        res.redirect("/");
        return null;
    }


    private static String generarHash(String string) throws NoSuchAlgorithmException {

        byte[] bytes = string.getBytes();
        MessageDigest md = MessageDigest.getInstance("MD5");
        return DatatypeConverter.printHexBinary(md.digest(bytes));
    }
}