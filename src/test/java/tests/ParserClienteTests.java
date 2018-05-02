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
	ParserCliente parser;
	
	@Before
	public void init() {
		parser = new ParserCliente();
		clientes = parser.obtenerCliente("src/main/resources/variosClientes.json");
	}
	
/* ------------------------- TESTS SOBRE CLIENTES ---------------------------------*/ 
	
	@Test
	public void coincidenNombres() {
		Assert.assertEquals("Belen", clientes[0].getNombre());
		Assert.assertEquals("Gaston", clientes[1].getNombre());
	}
	@Test
	public void cantidadDeDispositivos() {
		Assert.assertEquals(1, clientes[0].cantidadDispositivos());
		Assert.assertEquals(2, clientes[1].cantidadDispositivos());
	}
	@Test
	public void cantidadDeDispositivosApagados() {
		Assert.assertEquals(1, clientes[0].cantidadDispositivosApagados());
		Assert.assertEquals(1, clientes[1].cantidadDispositivosApagados());
	}
	@Test
	public void cantidadDeDispositivosEncendidos() {
		Assert.assertEquals(0, clientes[0].cantidadDispositivosEncendidos());
		Assert.assertEquals(1, clientes[1].cantidadDispositivosEncendidos());
	}
	@Test
	public void coincidenConsumos() {
		Assert.assertEquals(150f, clientes[0].consumo(),0.000005);
		Assert.assertEquals(220f, clientes[1].consumo(),0.000005);
	}
	@Test
	public void coincideTipoDeDocumento() {
		Assert.assertEquals(TipoDocumento.DNI, clientes[0].getTipoDocumento());
		Assert.assertEquals(TipoDocumento.LC, clientes[1].getTipoDocumento());
	}
	
	/* ------------------------- TESTS SOBRE EXCEPCIONES ---------------------------------*/ 

	
	@Test(expected=ParserException.class)
	public void elJSONMalFormateadoProvocaError() {
		clientes2 = parser.obtenerCliente("src/main/resources/json_mal_formateado.json");
	}
	@Test(expected=ArchivoNoEncontradoException.class)
	public void cuandoNoExisteElJsonLanzaExcepcion() {
		clientes2 = parser.obtenerCliente("src/main/resources/esteJsonNoexiste.json");
	}
}
