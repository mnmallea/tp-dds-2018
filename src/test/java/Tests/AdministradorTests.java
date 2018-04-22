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
		administrador.setFechaAlta(new LocalDate(2018,1,19));
	}
	
	@Test
	public void elAdministradorEstaHace3Meses() {//no se como testear bien esto porque hoy anda y mañana va a romper
		Assert.assertEquals(3, administrador.mesesDeAdministrador());
	}
}
