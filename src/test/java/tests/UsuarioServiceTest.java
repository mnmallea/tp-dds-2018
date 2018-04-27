package tests;

import dominio.Categorizador;
import dominio.Cliente;
import dominio.Dispositivo;
import dominio.TipoDocumento;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.UsuariosService;

import java.util.ArrayList;
import java.util.List;

public class UsuarioServiceTest {

	UsuariosService usuariosService;
	Cliente cliente;

	@Before
	public void init() {
		usuariosService = new UsuariosService();
		cliente = usuariosService.parserUsuarioToCliente();

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
}
