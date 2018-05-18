package tests;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.Categorizador;
import dominio.Cliente;
import dominio.Dispositivo;
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
	public Cliente cliente;

	@Before
	public void init() {

		Dispositivo heladera = new Dispositivo("heladera", 7.0f);
		Dispositivo tostadora = new Dispositivo("tostadora", 2.5f);
		Dispositivo microondas = new Dispositivo("microondas", 4.5f);

//		heladera.encenderse();; // encendemos uno

		List<Dispositivo> listaDeDispositivos = new ArrayList<Dispositivo>();

		listaDeDispositivos.add(heladera);
		listaDeDispositivos.add(tostadora);
		listaDeDispositivos.add(microondas);

		cliente = new Cliente("unNombre", "unApellido", TipoDocumento.DNI, 12345, 123, "unaCalle 123",
				Categorizador.instancia.getR1(), listaDeDispositivos, LocalDate.now()); // categoria R1
	}

	@Test
	public void elClienteTieneTresDispositivos() {
		Assert.assertEquals(3, cliente.getDispositivos().size());
	}

	@Test
	public void elClienteTieneAlgunDispositivoEncendido() {
		Assert.assertEquals(true, cliente.algunDispositivoEncendido());// heladera
	}
	
	@Test
	public void elClienteTieneUnDispositivoEncendido() {
		Assert.assertEquals(1, cliente.cantidadDispositivosEncendidos());
	}
	
	@Test
	public void elClienteTieneDosDispositivosApagados() {
		Assert.assertEquals(2, cliente.cantidadDispositivosApagados());
	}
	
	@Test
	public void seRecategorizaAlClienteYDeberiaQuedarEnR1() {
		cliente.categorizar();
		Assert.assertSame(Categorizador.instancia.getR1(), cliente.getCategoria());
	}
	
	@Test
	public void elClienteConsume14Kwh() {
		Assert.assertEquals(new Float(14f), cliente.consumo());
	}
}
