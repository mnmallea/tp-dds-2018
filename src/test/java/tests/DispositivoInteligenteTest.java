package tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import dominio.AhorroEnergia;
import dominio.Apagado;
import dominio.DispositivoInteligente;
import dominio.Fabricante;

public class DispositivoInteligenteTest {

	Fabricante fabricante = Mockito.mock(Fabricante.class);
	Fabricante fabricanteFallado = Mockito.mock(Fabricante.class);
	DispositivoInteligente dispositivo = new DispositivoInteligente("tele",new Apagado(), 30f, fabricante, 1l);
	DispositivoInteligente dispositivoFallado = new DispositivoInteligente("AC", new Apagado(), 30f, fabricanteFallado, 1l);

	@Before
	public void init() {
		Mockito.when(fabricante.consumoEnUltimasHoras(6, dispositivo.getIdDeFabrica())).thenReturn(80f);
		Mockito.doThrow(new RuntimeException()).when(fabricanteFallado)
				.encenderDispositivo(dispositivo.getIdDeFabrica());
		Mockito.doThrow(new RuntimeException()).when(fabricanteFallado).consumoEnUltimasHoras(2,
				dispositivo.getIdDeFabrica());
	}

	@Test
	public void elConsumoEnLasUltimas6HorasFueDe80() {
		Assert.assertEquals(80f, dispositivo.consumoEnUltimasHoras(6), 0.0005);
	}

	@Test
	public void seApagaUnDispositivoQueYaEstaApagadoYLaFabricaNuncaDebeSerLlamada() {
		dispositivo.apagarse();
		Mockito.verify(fabricante, Mockito.never()).apagarDispositivo(dispositivo.getIdDeFabrica());
		;
	}

	@Test
	public void sePoneEnAhorroDeEnergiaYAhorrarEnergiaDebioSerLlamadaUnaVez() {
		dispositivo.ahorrarEnergia();
		Mockito.verify(fabricante, Mockito.times(1)).ahorrarEnergia(dispositivo.getIdDeFabrica());
	}

	@Test
	public void sePoneEnAhorroDeEnergiaYAhoraSuEstadoDebeSerAhorro() {
		dispositivo.ahorrarEnergia();
		Assert.assertEquals(AhorroEnergia.class, dispositivo.getEstado().getClass());
	}

	@Test(expected = RuntimeException.class)
	public void noSePuedeEncenderUnDispositivoConFabricaQueFalla() {
		dispositivoFallado.encenderse();
	}

	@Test(expected = RuntimeException.class)
	public void noSePuedePreguntarleALaFabricaFalladaElConsumoEnUltimasHoras() {
		dispositivoFallado.consumoEnUltimasHoras(2);
	}

}
