package tests;

import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.*;

public class AdministradorTests {
	public Administrador administrador;
	
	@Before
	public void init() {
		administrador = new Administrador();
	}
	
	@Test
	public void elAdministradorEstaHace3Meses() {
		administrador.setFechaAlta(LocalDate.now().minusMonths(3));
		Assert.assertEquals(3, administrador.mesesDeAdministrador());
	}
	
	@Test
	public void elAdministradorEstaHace0meses() {
		administrador.setFechaAlta(new LocalDate());
		Assert.assertEquals(0, administrador.mesesDeAdministrador());
	}
}
