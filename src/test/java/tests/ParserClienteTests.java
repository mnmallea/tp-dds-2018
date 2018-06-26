package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import dominio.Cliente;
import dominio.DispositivoInteligente;
import dominio.Fabricante;
import dominio.TipoDocumento;
import exception.ArchivoNoEncontradoException;
import exception.ParserException;
import jsonAObjeto.ParserCliente;

public class ParserClienteTests {

	private Cliente[] clientes, clientes2;
	private Fabricante fabrica = Mockito.mock(Fabricante.class);
	
	@Before
	public void init() {
		clientes = ParserCliente.obtenerClientes("src/main/resources/variosClientes.json");
		DispositivoInteligente dispositivo = clientes[0].getDispositivosInteligentes().get(0);
		dispositivo.setFabricante(fabrica);
		Mockito.when(fabrica.consumoUltimoMes(dispositivo.getIdDeFabrica())).thenReturn(70f);
		
		
	}

	/*
	 * ------------------------- TESTS SOBRE CLIENTE BELEN
	 * ---------------------------------
	 */

	@Test
	public void belenSeLlamaBelen() {
		Assert.assertEquals("Belen", clientes[0].getNombre());
	}

	@Test
	public void belenTieneDosDispositivos() {
		Assert.assertEquals(2, clientes[0].cantidadDeDispositivos());
	}

	@Test
	public void belenTieneUnDispositivoEstandar() {
		Assert.assertEquals(1, clientes[0].cantidadDispositivosEstandar());
	}

	@Test
	public void belenTieneUnDispositivoInteligente() {
		Assert.assertEquals(1, clientes[0].cantidadDispositivosInteligentes());
	}

	@Test
	public void belenTieneUnDispositivoApagado() {
		Assert.assertEquals(0, clientes[0].cantidadDispositivosInteligentesApagados());
	}

	@Test
	public void belenTieneUnDispositivoEncendido() {
		Assert.assertEquals(1, clientes[0].cantidadDispositivosInteligentesEncendidos());
	}

	@Test
	public void belenConsume100() {
		Assert.assertEquals(100f, clientes[0].consumo(), 0.000005);
	}

	@Test
	public void belenTieneTipoDNI() {
		Assert.assertEquals(TipoDocumento.DNI, clientes[0].getTipoDocumento());
	}

	/*
	 * ------------------------- TESTS SOBRE CLIENTE GASTON
	 * ---------------------------------
	 */

	@Test
	public void gastonSeLlamaGaston() {
		Assert.assertEquals("Gaston", clientes[1].getNombre());
	}

	@Test
	public void gastonTieneDosDispositivos() {
		Assert.assertEquals(2, clientes[1].cantidadDeDispositivos());
	}

	@Test
	public void gastonTieneUnDispositivoApagado() {
		Assert.assertEquals(0, clientes[1].cantidadDispositivosInteligentesApagados());
	}

	@Test
	public void gastonTieneUnDispositivoEncendido() {
		Assert.assertEquals(0, clientes[1].cantidadDispositivosInteligentesEncendidos());
	}

	@Test
	public void gastonConsume60() {
		Assert.assertEquals(60f, clientes[1].consumo(), 0.000005);
	}

	@Test
	public void gastonTieneTipoLC() {
		Assert.assertEquals(TipoDocumento.LC, clientes[1].getTipoDocumento());
	}

	/*
	 * ------------------------- TESTS SOBRE EXCEPCIONES
	 * ---------------------------------
	 */

	@Test(expected = ParserException.class)
	public void elJSONMalFormateadoProvocaError() {
		clientes2 = ParserCliente.obtenerClientes("src/main/resources/json_mal_formateado.json");
	}

	@Test(expected = ArchivoNoEncontradoException.class)
	public void cuandoNoExisteElJsonLanzaExcepcion() {
		clientes2 = ParserCliente.obtenerClientes("src/main/resources/esteJsonNoexiste.json");
	}
}
