package repositorios;

import dominio.Cliente;

import java.util.ArrayList;
import java.util.List;

public class RepoClientes {
	public List<Cliente> clientes = new ArrayList<Cliente>();
	public static RepoClientes instancia = new RepoClientes();

	private RepoClientes() {
	}

	public void agregarClientes(Cliente unCliente){
		clientes.add(unCliente);
	}


}
