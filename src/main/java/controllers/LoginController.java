package controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import dominio.TipoUsuario;
import repositorios.RepoUsuarios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class LoginController {

	public static ModelAndView show(Request req, Response res) {
		return new ModelAndView(null, "home/login.hbs");
	}

	// tengo dudas sobre el noSuchAlgorithmException pero no me deja no ponerlo
	public static ModelAndView login(Request req, Response res) throws NoSuchAlgorithmException{
		
		Long usernameReq = Long.parseLong(req.queryParams("username"));
		String hashPasswordReq = generarHash(req.queryParams("password"));
		
		
		

		TipoUsuario usuarioPersistido = RepoUsuarios.instancia.tipoDeUsuario(usernameReq);
		String hashPasswordAlmacenada = RepoUsuarios.instancia.hashDePassword(usernameReq);
		
		
		if(hashPasswordAlmacenada.equalsIgnoreCase(hashPasswordReq))
			System.out.println("La password esta bien"); // y corresponde a ese usuario, o sea aca ya esta perfectamente logueado 
		else
			System.out.println("Contraseña incorrecta"); 
			
		
		
		switch (usuarioPersistido) {
		case ADMINISTRADOR:
			res.redirect("/administradores/" + usernameReq);

			break;

		case CLIENTE:
			res.redirect("/clientes/" + usernameReq);

			break;

		default:
			break;
		}

		req.session().attribute(LoginValidator.USER_SESSION_ID, usernameReq);
		// res.cookie(username.toString(),password);
		res.redirect("/");
		return null;
	}


	private static String generarHash(String string) throws NoSuchAlgorithmException {
		
		byte[] bytes = string.getBytes();
		MessageDigest md = MessageDigest.getInstance("MD5");
		return DatatypeConverter.printHexBinary(md.digest(bytes));
	}
}