package dominio;

import repositorios.RepoClientes;
import simplex.OptimizadorHoras;

import java.util.ArrayList;
import java.util.List;

public class AdministradorClientes {
    private List<Cliente> clientes = new ArrayList<Cliente>();

    public void agregarCliente(Cliente unCliente) {
        RepoClientes.instancia.agregarCliente(unCliente);
    }

    public List<Cliente> getClientes() {
        return RepoClientes.instancia.getClientes();
    }

    public void simplexarClientes() {
        this.clientes.forEach(cliente -> this.realizarSimplex(cliente));
    }

    public void realizarSimplex(Cliente cliente) {
        new OptimizadorHoras().optimizarCliente(cliente);
    }
}