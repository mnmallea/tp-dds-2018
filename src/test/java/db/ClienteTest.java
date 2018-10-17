package db;

import dominio.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;
import puntos.Point;
import repositorios.RepoClientes;

import java.time.LocalDate;
import java.util.ArrayList;

public class ClienteTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

    private Zona zona1;
    private Zona zona2;
    private Cliente cliente;

    @Before
    public void before() {
        zona1 = new Zona(45.0, new Point(0.0, 0.0));
        zona2 = new Zona(80.0, new Point(-1.0, 0.0));
        cliente = new Cliente("Julian Ezequiel", "Pico", TipoDocumento.DNI, 401, 456,
                new Direccion(new Point(2.0, 3.0), "Calle 5"), Categorizador.instancia.getR1(), new ArrayList<>(),
                new ArrayList<>(), LocalDate.now(), zona1);
    }

    @Test
    public void crearYRecuperarNuevoUsuario() {
        RepoClientes.instancia.guardarCliente(cliente);
        Cliente clienteRecuperado = RepoClientes.instancia.buscarClientePorId(this.cliente.getId());
        Assert.assertEquals(cliente, clienteRecuperado);
    }

    @Test
    public void cambiarGeoposicionamientoYRecuperar() {
        RepoClientes.instancia.guardarCliente(cliente);
        cliente.setZona(zona2);

        Assert.assertEquals(zona2, RepoClientes.instancia.buscarClientePorId(cliente.getId()).getZona());
    }
}
