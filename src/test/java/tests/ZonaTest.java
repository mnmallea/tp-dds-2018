package tests;

import dominio.Cliente;
import dominio.Direccion;
import dominio.Transformador;
import dominio.Zona;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import puntos.Point;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class ZonaTest {

	private Cliente cliente;
	private Cliente cliente2;
	private Zona zona;
	private Transformador transformador1;
	private Transformador transformador2;

	@Before
	public void setUp() {
		cliente = Mockito.mock(Cliente.class);
		Mockito.when(cliente.consumo()).thenReturn(100.0f);
		Mockito.when(cliente.getDireccion()).thenReturn(new Direccion(new Point(20, 0), "Av. Siempreviva"));

		cliente2 = Mockito.mock(Cliente.class);
		Mockito.when(cliente2.consumo()).thenReturn(345.0f);
		Mockito.when(cliente2.getDireccion()).thenReturn(new Direccion(new Point(-10, -0), "Av. Siempreviva"));

		zona = new Zona(25.0, new Point(0, 0));
	}

	private void agregarClientesAZona() {
		transformador1 = new Transformador(new Point(8.0, -5.0));
		transformador2 = new Transformador(new Point(-4, 3));
		zona.setTransformadores(Arrays.asList(transformador1, transformador2));
		zona.asignarClienteATransformador(cliente);
		zona.asignarClienteATransformador(cliente2);
	}

	@Test
	public void zonaAsignaClienteATransformador() {
		Transformador transformador = new Transformador(new Point(1, 0));
		zona.setTransformadores(Collections.singletonList(transformador));
		zona.asignarClienteATransformador(cliente);
		assertEquals(transformador.getClientes(), Collections.singletonList(cliente));
	}

	@Test
	public void elClienteDebeIrAPararAlTransformador2PorSerElMasCercano() {
		transformador2 = new Transformador(new Point(3, 4));
		transformador1 = new Transformador(new Point(1, 0));
		zona.setTransformadores(Arrays.asList(transformador1, transformador2));
		zona.asignarClienteATransformador(cliente);
		assertEquals(transformador2.getClientes(), Collections.singletonList(cliente));
	}

	@Test
	public void seAgreganClientesALaZonaYElConsumoDeberiaSer445() {
		this.agregarClientesAZona();
		assertEquals(445, zona.consumoTotal(), 0.05);
	}

	@Test
	public void elConsumoDelTransformador1DeberiaSer100() {
		this.agregarClientesAZona();
		assertEquals(100, transformador1.energiaSuministrada(), 0.01);
	}

	@Test
	public void elConsumoDelTransformador2DeberiaSer345() {
		this.agregarClientesAZona();
		assertEquals(345, transformador2.energiaSuministrada(), 0.01);
	}

}