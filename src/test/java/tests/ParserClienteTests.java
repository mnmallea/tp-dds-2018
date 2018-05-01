package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.Cliente;
import dominio.TipoDocumento;
import jsonAObjeto.ParserCliente;
import exception.ParserException;

public class ParserClienteTests {
	
	Cliente cliente, cliente2;
	ParserCliente parser;
	
	@Before
	public void init() {
		parser = new ParserCliente();
		cliente = parser.obtenerCliente("src/main/resources/fake.json");
	}
	@Test
	public void probandoNuevoJson() {
		Assert.assertEquals("Belen", cliente.getNombre());
	}
	@Test
	public void elClienteTieneUnDispositivo() {
		Assert.assertEquals(1, cliente.cantidadDispositivos());
	}
	@Test
	public void elClienteTieneUnDispositivoApagado() {
		Assert.assertEquals(1, cliente.cantidadDispositivosApagados());
	}
	@Test
	public void elConsumoDelClienteEs150() {
		Assert.assertEquals(150f, cliente.consumo(),0.000005);
	}
	@Test
	public void elTipoDeDocumentoEsDNI() {
		Assert.assertEquals(TipoDocumento.DNI, cliente.getTipoDocumento());
	}
	@Test(expected=ParserException.class)
	public void elJSONMalFormateadoProvocaError() {
		cliente2 = parser.obtenerCliente("src/main/resources/json_mal_formateado.json");
	}
}
