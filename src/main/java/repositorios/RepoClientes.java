package repositorios;

import dominio.Cliente;

import java.util.ArrayList;
import java.util.List;

public class RepoClientes {
    private List<Cliente> clientes = new ArrayList<Cliente>();
    public static final RepoClientes instancia = new RepoClientes();

    private RepoClientes() {
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void agregarCliente(Cliente unCliente) {
        clientes.add(unCliente);
    }

    public void limpiarClientes() {
        clientes = new ArrayList<>();
    }
}
