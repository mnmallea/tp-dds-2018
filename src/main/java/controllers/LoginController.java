package controllers;

import org.eclipse.jetty.util.security.Credential.MD5;

import dominio.TipoUsuario;
import repositorios.RepoUsuarios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class LoginController {


    public static ModelAndView show(Request req, Response res){
        return new ModelAndView(null, "home/login.hbs");
    }

    public static ModelAndView login(Request req, Response res) {
        Long username = Long.parseLong(req.queryParams("username"));
        
        String password = MD5.digest(req.queryParams("password"));
        
        TipoUsuario usuarioPersistido = RepoUsuarios.instancia.tipoDeUsuario(username);
        
        switch (usuarioPersistido) {
		case ADMINISTRADOR:
			res.redirect("/administradores/"+username);
			
			break;

		case CLIENTE:
			res.redirect("/clientes/"+username);
			
			break;

		default:
			break;
		}
        
        req.session().attribute(LoginValidator.USER_SESSION_ID, username);
        res.cookie(username.toString(),password);
        res.redirect("/");
        return null;
    }
}