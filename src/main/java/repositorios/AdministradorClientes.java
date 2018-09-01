package repositorios;

import dominio.Cliente;
import dominio.Zona;
import simplex.OptimizadorHoras;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdministradorClientes {
    public static final AdministradorClientes instancia = new AdministradorClientes();
    private List<Cliente> clientes = new ArrayList<Cliente>();

    private AdministradorClientes() {
    }

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

    public List<Cliente> inicializarClientes(Zona zona) {
        List<Cliente> clientes = AdministradorClientes.instancia.getClientes();
        return clientes.stream().filter(cliente -> cliente.getZona().equals(zona)).collect(Collectors.toList());
    }

}