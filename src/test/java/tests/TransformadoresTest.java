package tests;

import dominio.Cliente;
import dominio.Direccion;
import dominio.Transformador;
import dominio.Zona;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import puntos.Point;
import repositorios.Mapa;
import repositorios.RepoClientes;

public class TransformadoresTest {
	private Zona zona = new Zona(6.0, new Point(0, 0));
	private Transformador transformador1 = new Transformador(new Point(1, 0));
	private Transformador transformador2 = new Transformador(new Point(50, 50));
	Cliente cliente = Mockito.mock(Cliente.class);
	Cliente cliente2 = Mockito.mock(Cliente.class);

	@Before
	public void setUp() {
		Mockito.when(cliente.consumo()).thenReturn(100.0f);
		Mockito.when(cliente2.consumo()).thenReturn(50.0f);
		Mockito.when(cliente.transformadorMasCercano()).thenCallRealMethod();
		Mockito.when(cliente2.transformadorMasCercano()).thenCallRealMethod();
		Mockito.when(cliente.getDireccion()).thenReturn(new Direccion(new Point(0,0), "Calle"));
		Mockito.when(cliente2.getDireccion()).thenReturn(new Direccion(new Point(51,50), "Calle"));

		Mapa.instancia.agregarZona(zona);
		RepoClientes.instancia.agregarCliente(cliente);
		RepoClientes.instancia.agregarCliente(cliente2);
		zona.agregarTransformador(transformador1);

	}

	@Test
	public void hayUnSoloTransformadorEnLaZonaYElConsumoDebeSer150(){
		Assert.assertEquals(150.0, zona.consumoTotal(), 0.05);
	}
	
	@Test
	public void alTransformador1LeCorresponden2Clientes() {
		List<Cliente> clientes = RepoClientes.instancia.clientesDeTransformador(transformador1);
		Assert.assertEquals(2, clientes.size());
	}

	@Test
	public void elConsumoDelTransformador1DebeSer150() {
		Assert.assertEquals(150d, transformador1.energiaSuministrada(), 0.05);
	}
	
	@Test(expected = RuntimeException.class)
	public void noSePuedeAgregarElTranformadorDosALaZona() {
		zona.agregarTransformador(transformador2);
	}
}
