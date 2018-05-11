package tests;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dominio.Administrador;
import exception.ArchivoNoEncontradoException;
import exception.ParserException;
import jsonAObjeto.ParserAdministrador;

public class ParserAdministradorTests {
	
	Administrador[] administradores, administradores2;
	
	@Before
	public void init() {
		administradores = ParserAdministrador.obtenerAdministradores("src/main/resources/variosAdministradores.json");
	}
	
/* ------------------------- TESTS SOBRE ADMINISTRADOR ERIC ---------------------------------*/ 
	
	@Test
	public void ericSeLlamaEric() {
		Assert.assertEquals("Eric", administradores[0].getNombre());
	}
	@Test
	public void ericTieneNroDeIdentificacion123() {
		Assert.assertEquals(new Integer(123), administradores[0].getNroIdentificacion());
	}
	@Test
	public void ericSeDioDeAltaEl11_05_2018() {
		Assert.assertEquals(LocalDate.of(2018, 05, 11), administradores[0].getFechaAlta());
	}
	
/* ------------------------- TESTS SOBRE ADMINISTRADOR FRANCO ---------------------------------*/ 
	
	@Test
	public void francoSeLlamaFranco() {
		Assert.assertEquals("Franco", administradores[1].getNombre());
	}
	@Test
	public void francoTieneNroDeIdentificacion123() {
		Assert.assertEquals(new Integer(456), administradores[1].getNroIdentificacion());
	}
	@Test
	public void francoSeDioDeAltaEl11_05_1997() {
		Assert.assertEquals(LocalDate.of(1997, 05, 11), administradores[1].getFechaAlta());
	}

/* ------------------------- TESTS SOBRE ADMINISTRADOR MARTIN ---------------------------------*/ 
	
	@Test
	public void martinSeLlamaMartin() {
		Assert.assertEquals("Martin", administradores[2].getNombre());
	}
	@Test
	public void martinTieneNroDeIdentificacion123() {
		Assert.assertEquals(new Integer(789), administradores[2].getNroIdentificacion());
	}
	@Test
	public void martinSeDioDeAltaEl10_05_1998() {
		Assert.assertEquals(LocalDate.of(1998, 05, 10), administradores[2].getFechaAlta());
	}
	

/* ------------------------- TESTS SOBRE EXCEPCIONES ---------------------------------*/ 
	
	@Test(expected=ParserException.class)
	public void elJSONMalFormateadoProvocaError() {
		administradores2 = ParserAdministrador.obtenerAdministradores("src/main/resources/json_mal_formateado.json");
	}
	@Test(expected=ArchivoNoEncontradoException.class)
	public void cuandoNoExisteElJsonLanzaExcepcion() {
		administradores = ParserAdministrador.obtenerAdministradores("src/main/resources/esteJsonNoexiste.json");
	}
}
