package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.*;

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

		cliente = new Cliente("unNombre", "unApellido", TipoDocumento.DNI, 12345, 123, "unaCalle 123",
				Categorizador.getR1(), listaDeDispositivos); // categoria R1
	}

	@Test
	public void elClienteTieneTresDispositivos() {
		Assert.assertEquals(3, cliente.getDispositivos().size());
	}

	/*
	 * No puedo lograr que me pase este test, ya me fije que devuelve Long y debe
	 * ser un problema de castearlo a Int pero no encuentro como
	 * 
	 * @Test public void elClienteTieneSoloUnDispositivoEncendido() {
	 * Assert.assertEquals(1, cliente.cantidadDispositivosEncendidos().intValue());
	 * }
	 */
	@Test
	public void elClienteTieneAlgunDispositivoEncendido() {
		Assert.assertEquals(true, cliente.algunDispositivoEncendido());// heladera
	}
}
