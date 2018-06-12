package jsonAObjeto;

import java.io.Reader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dominio.Cliente;
import dominio.Estado;
import exception.ParserException;

public class ParserCliente {

	public static Cliente[] obtenerClientes(String file) {
		Cliente[] clientes;
		Reader reader = FileOpener.abrirArchivo(file);
		Gson gson = new GsonBuilder().registerTypeAdapter(Estado.class, new EstadoDeserializer()).create();
		try {
			clientes = gson.fromJson(reader, Cliente[].class);
		}
		catch(RuntimeException e) {
			throw new ParserException(e);
		}
		return clientes;
	}
}
