package Tests;

import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Dominio.*;

public class AdministradorTests {
	public Administrador administrador;
	
	@Before
	public void init() {
		administrador = new Administrador();
		new LocalDate();
		administrador.setFechaAlta(LocalDate.now().minusMonths(3));
	}
	
	@Test
	public void elAdministradorEstaHace3Meses() {
		Assert.assertEquals(3, administrador.mesesDeAdministrador());
	}
}
