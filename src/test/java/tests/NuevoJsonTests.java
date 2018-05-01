package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.Cliente;
import jsonAObjeto.ParserCliente;

public class NuevoJsonTests {
	
	Cliente cliente;
	ParserCliente parser;
	
	@Before
	public void init() {
		parser = new ParserCliente();
	}
	@Test
	public void probandoNuevoJson() {
		cliente = parser.obtenerCliente("src/main/resources/fake.json");
		Assert.assertEquals("Belen", cliente.getNombre());
	}
}
