package tests;

import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.Administrador;

public class AdministradorTests {
	public Administrador administrador, administradorNuevo;
	
	@Before
	public void init() {
		administrador = new Administrador("Alexis", "Gabadian", LocalDate.now().minusMonths(3), 123);
		administradorNuevo = new Administrador("Alexis", "Gabadian", LocalDate.now(), 123);
	}
	
	@Test
	public void elAdministradorEstaHace3Meses() {
		Assert.assertEquals(3, administrador.mesesDeAdministrador());
	}
	
	@Test
	public void elAdministradorEstaHace0meses() {
		Assert.assertEquals(0, administradorNuevo.mesesDeAdministrador());
	}
}
