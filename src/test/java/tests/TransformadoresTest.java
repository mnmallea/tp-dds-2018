package tests;

import dominio.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import puntos.Point;
import repositorios.AdministradorClientes;
import repositorios.RepoClientes;
import repositorios.RepoTransformadores;

import java.util.ArrayList;
import java.util.List;

public class TransformadoresTest {
    Cliente cliente = Mockito.mock(Cliente.class);
    Cliente cliente2 = Mockito.mock(Cliente.class);
    private Zona zona = new Zona(6.0, new Point(0, 0));
    private Transformador transformador1 = new Transformador(new Point(1, 0));
    private Transformador transformador2 = new Transformador(new Point(50, 50));
    private List<Transformador> transformadores = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    @Before
    public void setUp() {
        Mockito.when(cliente.consumo()).thenReturn(100.0f);
        Mockito.when(cliente2.consumo()).thenReturn(50.0f);
        Mockito.when(cliente.getDireccion()).thenReturn(new Direccion(new Point(0, 0), "Calle"));
        Mockito.when(cliente2.getDireccion()).thenReturn(new Direccion(new Point(51, 50), "Calle"));

        AdministradorClientes.instancia.agregarCliente(cliente);
        AdministradorClientes.instancia.agregarCliente(cliente2);
        transformadores.add(transformador1);
        transformadores.add(transformador2);
        zona.setTransformadores(transformadores);
        clientes.add(cliente);
        clientes.add(cliente2);
        transformador1.setClientes(clientes);
        RepoClientes.instancia.setClientes(clientes);
        RepoTransformadores.instancia.setTransformadores(transformadores);

    }

    @After
    public void tearDown() {
        RepoTransformadores.instancia.limpiarTransformadores();
        RepoClientes.instancia.limpiarClientes();
   }

    @Test
    public void hayUnSoloTransformadorEnLaZonaYElConsumoDebeSer150() {
        zona.consumoTotal();
        Assert.assertEquals(150.0, zona.consumoTotal(), 0.05);
    }


    @Test
    public void elConsumoDelTransformador1DebeSer150() {
        Assert.assertEquals(150d, transformador1.energiaSuministrada(), 0.05);
    }

}
