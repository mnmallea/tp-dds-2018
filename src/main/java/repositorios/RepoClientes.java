package repositorios;

import dominio.Cliente;
import dominio.Transformador;
import simplex.OptimizadorHoras;
import simplex.SolucionSimplex;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepoClientes {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	public static final RepoClientes instancia = new RepoClientes();

	private RepoClientes() {
	}

	public void agregarCliente(Cliente unCliente) {
		clientes.add(unCliente);
	}

	public void limpiarClientes(){
		clientes = new ArrayList<>();
	}

	public List<Cliente> clientesDeTransformador(Transformador transformador) {
		return clientes.stream().filter(cliente -> cliente.transformadorMasCercano() == transformador)
				.collect(Collectors.toList());
	}

	public void simplexarClientes() {
		this.clientes.forEach(cliente -> this.realizarSimplex(cliente));
	}

	public void realizarSimplex(Cliente cliente) {
		new OptimizadorHoras().optimizarCliente(cliente);
	}
}