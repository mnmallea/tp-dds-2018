package repositorios;

import dominio.Cliente;
import dominio.Transformador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepoClientes {
	public List<Cliente> clientes = new ArrayList<Cliente>();
	public static RepoClientes instancia = new RepoClientes();

	private RepoClientes() {
	}

	public void agregarClientes(Cliente unCliente){
		clientes.add(unCliente);
	}


	public List<Cliente> clientesDeTransformador(Transformador transformador) {
		return clientes.stream().filter(cliente -> cliente.transformadorMasCercano() == transformador).collect(Collectors.toList());
	}
}
