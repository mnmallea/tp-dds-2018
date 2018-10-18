package repositorios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import dominio.Cliente;
import dominio.Transformador;
import simplex.OptimizadorHoras;

public class AdministradorClientes {
    public static final AdministradorClientes instancia = new AdministradorClientes();
    private List<Cliente> clientes = new ArrayList<Cliente>();

    private AdministradorClientes() {
    }

    public void agregarCliente(Cliente unCliente) {
        RepoClientes.instancia.guardarCliente(unCliente);
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
    
    public Transformador transformadorMasCercano(Cliente cliente,List<Transformador> transformadores) {
    	return transformadores.stream()
    	.min(Comparator.comparingDouble(tran -> cliente.getDireccion().getCoordenada().distance(tran.getCoordenadas())))
    	.get();
    }
    

    public List<Cliente> inicializarClientes(Transformador transformador) {
        List<Cliente> clientes = AdministradorClientes.instancia.getClientes();
        List<Transformador> transformadores = AdministradorTransformadores.instancia.getTransformadores();
        
        
        return clientes.stream().filter(cliente -> this.transformadorMasCercano(cliente, transformadores).equals(transformador))
        		.collect(Collectors.toList()); 
    }
}