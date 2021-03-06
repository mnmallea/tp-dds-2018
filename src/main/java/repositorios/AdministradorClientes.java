package repositorios;

import dominio.Cliente;
import dominio.Transformador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import simplex.OptimizadorHoras;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdministradorClientes {
    private static final Logger logger = LoggerFactory.getLogger(AdministradorClientes.class);
    public static final AdministradorClientes instancia = new AdministradorClientes();

    private AdministradorClientes() {
    }

    public void agregarCliente(Cliente unCliente) {
        RepoClientes.instancia.guardarCliente(unCliente);
    }

    public List<Cliente> getClientes() {
        return RepoClientes.instancia.getClientes();
    }

    public void simplexarClientes() {
        this.getClientes().forEach(cliente -> {
            try {
                this.realizarSimplex(cliente);
            } catch (Exception ex) {
                logger.error("Error al realizar el simplex para el cliente " + cliente.getId(), ex);
            }
        });
    }

    public void realizarSimplex(Cliente cliente) {
        new OptimizadorHoras().optimizarCliente(cliente);
    }

    public Optional<Transformador> transformadorMasCercano(Cliente cliente) {
        List<Transformador> transformadores = AdministradorTransformadores.instancia.getTransformadores();
        return transformadores.stream()
                .min(Comparator.comparingDouble(transformador -> cliente.distanciaA(transformador.getCoordenadas())));
    }

    public Boolean esElTransformadorMasCercanoA(Cliente cliente, Transformador transformador) {
        return transformadorMasCercano(cliente).orElse(transformador).equals(transformador);
    }


    public List<Cliente> obtenerClientesDeTransformador(Transformador transformador) {
        List<Cliente> clientes = this.getClientes();

        return clientes.stream().filter(cliente -> this.esElTransformadorMasCercanoA(cliente, transformador))
                .collect(Collectors.toList());
    }
}