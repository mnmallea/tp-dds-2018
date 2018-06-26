package tests;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import dominio.Apagado;
import dominio.Categorizador;
import dominio.Cliente;
import dominio.DispositivoEstandar;
import dominio.DispositivoInteligente;
import dominio.Encendido;
import dominio.Fabricante;
import dominio.TipoDocumento;

/*
 *Pruebas para hacer:
 *	Saber si alguno de sus dispositivos está encendido
 	Saber la cantidad de dispositivos encendidos
 	Saber la cantidad de dispositivos apagados
 	Informar la cantidad total de dispositivos que posee 
 *  
 */

public class ClienteTest {
	private Cliente cliente;
	private Fabricante fabricante;

	private DispositivoEstandar heladera;
	private DispositivoEstandar tostadora;
	private DispositivoInteligente microondas;
	private DispositivoInteligente lavavajillas;

	@Before
	@SuppressWarnings("unchecked")
	public void init() {
		fabricante = Mockito.mock(Fabricante.class);
		heladera = new DispositivoEstandar("heladera", 7f, 4f);
		tostadora = new DispositivoEstandar("tostadora", 2f, 3f);
		microondas = new DispositivoInteligente("microondas", new Encendido(), 1f, fabricante, 15l);
		lavavajillas = new DispositivoInteligente("lavavajillas de la cocina", new Apagado(), 1f,
				fabricante, 16l);
		
		Mockito.when(fabricante.consumoUltimoMes(microondas.getIdDeFabrica())).thenReturn(10f);
		Mockito.when(fabricante.consumoUltimoMes(lavavajillas.getIdDeFabrica())).thenReturn(0f);
		
		List<DispositivoEstandar> dispositivosEstandar = Arrays.asList(heladera, tostadora);
		List<DispositivoInteligente> dispositivosInteligentes = Arrays.asList(microondas, lavavajillas);

		cliente = new Cliente("unNombre", "unApellido", TipoDocumento.DNI, 12345, 123, "unaCalle 123",
				Categorizador.instancia.getR1(), dispositivosInteligentes, dispositivosEstandar, LocalDate.now()); // categoria
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
