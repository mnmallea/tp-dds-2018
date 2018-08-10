package tests;

import dominio.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import puntos.Point;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ClienteTest {
	private Cliente cliente;
	private Fabricante fabricante;

	private DispositivoEstandar heladera;
	private DispositivoEstandar tostadora;
	private DispositivoInteligente microondas;
	private DispositivoInteligente lavavajillas;

	@Before
	public void init() {
		fabricante = Mockito.mock(Fabricante.class);
		heladera = new DispositivoEstandar("heladera", 7f, 4f);
		tostadora = new DispositivoEstandar("tostadora", 2f, 3f);
		microondas = new DispositivoInteligente<>("microondas", new Encendido(), 1f, fabricante, 15L);
		lavavajillas = new DispositivoInteligente<>("lavavajillas de la cocina", new Apagado(), 1f,
				fabricante, 16L);

		Mockito.when(fabricante.consumoUltimoMes(microondas.getIdDeFabrica())).thenReturn(10f);
		Mockito.when(fabricante.consumoUltimoMes(lavavajillas.getIdDeFabrica())).thenReturn(0f);

		List<DispositivoEstandar> dispositivosEstandar = Arrays.asList(heladera, tostadora);
		List<DispositivoInteligente> dispositivosInteligentes = Arrays.asList(microondas, lavavajillas);

		cliente = new Cliente("unNombre", "unApellido", TipoDocumento.DNI, 12345, 123, new Direccion(new Point(40, 20), "Calle falsa 123"),
				Categorizador.instancia.getR1(), dispositivosInteligentes, dispositivosEstandar, LocalDate.now(), ); // categoria
		// R1
	}

	@Test
	public void elClienteTieneCuatroDispositivos() {
		Assert.assertEquals(4, cliente.cantidadDeDispositivos());
	}

	@Test
	public void elClienteTieneAlgunDispositivoEncendido() {
		Assert.assertTrue(cliente.algunDispositivoEncendido());// microondas
	}

	@Test
	public void elClienteTieneUnDispositivoEncendido() {
		Assert.assertEquals(1, cliente.cantidadDispositivosInteligentesEncendidos());
	}

	@Test
	public void elClienteTieneUnDispositivoApagados() {
		Assert.assertEquals(1, cliente.cantidadDispositivosInteligentesApagados());
	}

	@Test
	public void seRecategorizaAlClienteYDeberiaQuedarEnR8() {
		cliente.categorizar();
		Assert.assertSame(Categorizador.instancia.getR8(), cliente.getCategoria());
	}

	@Test
	public void elClienteConsume14Kwh() {
		Assert.assertEquals(new Float(1030f), cliente.consumo());
	}
}
