package jsonAObjeto;

import java.io.Reader;
import com.google.gson.Gson;
import dominio.Cliente;

public class ParserCliente {

	public Cliente obtenerCliente(String file) {
		Cliente cliente;
		Reader reader = FileOpener.abrirArchivo(file);
		Gson gson = new Gson();
		cliente = gson.fromJson(reader, Cliente.class);
		return cliente;
	}
}
