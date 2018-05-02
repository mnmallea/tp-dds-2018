package jsonAObjeto;

import java.io.Reader;
import com.google.gson.Gson;
import dominio.Cliente;
import exception.ParserException;

public class ParserCliente {

	public Cliente[] obtenerCliente(String file) {
		Cliente[] clientes;
		Reader reader = FileOpener.abrirArchivo(file);
		Gson gson = new Gson();
		try {
			clientes = gson.fromJson(reader, Cliente[].class);
		}
		catch(RuntimeException e) {
			throw new ParserException(e);
		}
		return clientes;
	}
}
