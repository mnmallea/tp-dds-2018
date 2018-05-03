package jsonAObjeto;

import java.io.Reader;
import com.google.gson.Gson;
import dominio.Administrador;
import exception.ParserException;

public class ParserAdministrador {

	public Administrador[] obtenerAdministradores(String file) {
		Administrador[] administradores;
		Reader reader = FileOpener.abrirArchivo(file);
		Gson gson = new Gson();
		try {
			administradores = gson.fromJson(reader, Administrador[].class);
		}
		catch(RuntimeException e) {
			throw new ParserException(e);
		}
		return administradores;
	}
}
