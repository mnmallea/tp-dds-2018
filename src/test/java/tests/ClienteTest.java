package tests;

import dominio.Categorizador;
import dominio.Cliente;
import dominio.Dispositivo;
import dominio.TipoDocumento;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

		Dispositivo heladera = new Dispositivo("heladera", 7.0);
		Dispositivo tostadora = new Dispositivo("tostadora", 2.5);
		Dispositivo microondas = new Dispositivo("microondas", 4.5);

		heladera.setEncendido(true); // encendemos uno

		List<Dispositivo> listaDeDispositivos = new ArrayList<Dispositivo>();

		listaDeDispositivos.add(heladera);
		listaDeDispositivos.add(tostadora);
		listaDeDispositivos.add(microondas);

		//Cliente de categoria R1 (su consumo en el mes anterior fue 120)
		cliente = new Cliente("unNombre", "unApellido", TipoDocumento.DNI, 12345, 123, "unaCalle 123", 120f, listaDeDispositivos); 
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
	public void elClienteEsDeCategoriaR1(){
		Assert.assertSame(Categorizador.getR1(), cliente.getCategoria());
	}
}
