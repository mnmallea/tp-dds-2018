package controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import dominio.Administrador;
import dominio.Cliente;
import dominio.TipoUsuario;
import dominio.Usuario;
import repositorios.RepoUsuarios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import static spark.Spark.halt;

public class LoginController {

    public static ModelAndView show(Request req, Response res) {
        return new ModelAndView(null, "home/login.hbs");
    }

    // tengo dudas sobre el noSuchAlgorithmException pero no me deja no ponerlo
    public static ModelAndView login(Request req, Response res) throws NoSuchAlgorithmException {

        String usernameReq = req.queryParams("username");
        String password = req.queryParams("password");

        Usuario usuario = RepoUsuarios.instancia.findUsuarioByUsername(usernameReq);

        if(usuario == null){
            System.out.println("No existe el usuario ingresado");
            res.redirect("/login");
        }


//		TipoUsuario usuarioPersistido = RepoUsuarios.instancia.tipoDeUsuario(usernameReq);
//		String hashPasswordAlmacenada = RepoUsuarios.instancia.hashDePassword(usernameReq);
//

        if (PasswordUtil.verifyPassword(password, usuario.getHashedPassword()))
            System.out.println("La password esta bien"); // y corresponde a ese usuario, o sea aca ya esta perfectamente logueado
        else{
            System.out.println("Contraseña incorrecta");
            halt(401);
        }

        TipoUsuario tipoUsuario = null;
        if (usuario instanceof Administrador) {
            res.redirect("/administrador");
            tipoUsuario = TipoUsuario.ADMINISTRADOR;
        } else if (usuario instanceof Cliente) {
            res.redirect("/cliente");
            tipoUsuario = TipoUsuario.CLIENTE;
        }


        req.session().attribute(LoginValidator.USER_SESSION_ID, usuario.getId());
        req.session().attribute(LoginValidator.USER_TYPE, tipoUsuario);

        res.redirect("/");
        return null;
    }


    private static String generarHash(String string) throws NoSuchAlgorithmException {

        byte[] bytes = string.getBytes();
        MessageDigest md = MessageDigest.getInstance("MD5");
        return DatatypeConverter.printHexBinary(md.digest(bytes));
    }
}