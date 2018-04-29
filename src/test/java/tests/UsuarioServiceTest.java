package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonSyntaxException;

import dominio.Cliente;
import service.UsuariosService;

public class UsuarioServiceTest {

	UsuariosService usuariosService;
	Cliente cliente;
	Cliente cliente2;

	@Before
	public void init() {
		usuariosService = new UsuariosService();
		cliente = usuariosService.parserUsuarioToCliente("src/main/resources/modeljson.json");
	}

	@Test
	public void elClienteSeLlamaBelen() {
		Assert.assertEquals("Belen", cliente.getNombre());
	}

	@Test
	public void elClienteTiene1Dispositivo() {
		Assert.assertEquals(1, cliente.cantidadDispositivos());
	}
	
	@Test
	public void elClienteNoTieneDispositivosEncendidos() {
		Assert.assertFalse(cliente.algunDispositivoEncendido());
	}
	
	@Test(expected = JsonSyntaxException.class)
	public void elCliente2Rompe() {
		cliente2 = usuariosService.parserUsuarioToCliente("src/main/resources/fake.json");
		
		Assert.assertTrue(false);
	}
}
