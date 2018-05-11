package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.Cliente;
import dominio.TipoDocumento;
import exception.ArchivoNoEncontradoException;
import exception.ParserException;
import jsonAObjeto.ParserCliente;

public class ParserClienteTests {
	
	Cliente[] clientes, clientes2;
	
	@Before
	public void init() {
		clientes = ParserCliente.obtenerClientes("src/main/resources/variosClientes.json");
	}
	
/* ------------------------- TESTS SOBRE CLIENTE BELEN ---------------------------------*/ 
	
	@Test
	public void belenSeLlamaBelen() {
		Assert.assertEquals("Belen", clientes[0].getNombre());
	}
	@Test
	public void belenTieneUnDispositivo() {
		Assert.assertEquals(1, clientes[0].cantidadDispositivos());
	}
	@Test
	public void belenTieneUnDispositivoApagado() {
		Assert.assertEquals(1, clientes[0].cantidadDispositivosApagados());
	}
	@Test
	public void belenNoTieneDispositivosEncendidos() {
		Assert.assertEquals(0, clientes[0].cantidadDispositivosEncendidos());
	}
	@Test
	public void belenConsume150() {
		Assert.assertEquals(150f, clientes[0].consumo(),0.000005);
	}
	@Test
	public void belenTieneTipoDNI() {
		Assert.assertEquals(TipoDocumento.DNI, clientes[0].getTipoDocumento());
	}
	
/* ------------------------- TESTS SOBRE CLIENTE GASTON ---------------------------------*/

	@Test
	public void gastonSeLlamaGaston() {
		Assert.assertEquals("Gaston", clientes[1].getNombre());
	}
	@Test
	public void gastonTieneDosDispositivos() {
		Assert.assertEquals(2, clientes[1].cantidadDispositivos());
	}
	@Test
	public void gastonTieneUnDispositivoApagado() {
		Assert.assertEquals(1, clientes[1].cantidadDispositivosApagados());
	}
	@Test
	public void gastonTieneUnDispositivoEncendido() {
		Assert.assertEquals(1, clientes[1].cantidadDispositivosEncendidos());
	}
	@Test
	public void gastonConsume220() {
		Assert.assertEquals(220f, clientes[1].consumo(),0.000005);
	}
	@Test
	public void gastonTieneTipoLC() {
		Assert.assertEquals(TipoDocumento.LC, clientes[1].getTipoDocumento());
	}
	
/* ------------------------- TESTS SOBRE EXCEPCIONES ---------------------------------*/ 
	
	@Test(expected=ParserException.class)
	public void elJSONMalFormateadoProvocaError() {
		clientes2 = ParserCliente.obtenerClientes("src/main/resources/json_mal_formateado.json");
	}
	@Test(expected=ArchivoNoEncontradoException.class)
	public void cuandoNoExisteElJsonLanzaExcepcion() {
		clientes2 = ParserCliente.obtenerClientes("src/main/resources/esteJsonNoexiste.json");
	}
}
