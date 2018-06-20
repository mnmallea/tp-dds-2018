package tests;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import actuadores.Actuador;
import actuadores.ActuadorBajaTemperaturaAC;
import actuadores.ActuadorEncenderAC;
import actuadores.ReglaParaTemperatura;
import actuadores.SensorTemperatura;
import dominio.AireAcondicionadoInteligente;
import dominio.Apagado;
import dominio.DispositivoInteligente;
import dominio.Encendido;
import dominio.FabricanteAireAcondicionado;

public class AireTest {
	private Actuador actuadorEnciendeAire;
	private Actuador actuadorBajaTemperatura;
	private ReglaParaTemperatura reglaParaEncenderAire;
	private ReglaParaTemperatura reglaParaBajarTemperatura;
	private DispositivoInteligente aire;
	private FabricanteAireAcondicionado fabricante;
	private SensorTemperatura sensor;
	
	@Before
	public void init() {
		fabricante = Mockito.mock(FabricanteAireAcondicionado.class);
		aire = new AireAcondicionadoInteligente("Aire LG", new Apagado(), 65.0f, fabricante, 1l);
		actuadorEnciendeAire = new ActuadorEncenderAC();
		reglaParaEncenderAire = new ReglaParaTemperatura(aire, actuadorEnciendeAire);
		actuadorBajaTemperatura = new ActuadorBajaTemperaturaAC(3);
		reglaParaBajarTemperatura = new ReglaParaTemperatura(aire, actuadorBajaTemperatura);
		sensor = new SensorTemperatura(Arrays.asList(reglaParaEncenderAire, reglaParaBajarTemperatura));
		
	}
	
	@Test
	public void elAireSeDebeEncender() {
		sensor.laTemperaturaCambioA(25.0);
		Assert.assertEquals(Encendido.class, aire.getEstado().getClass());
	}
	
	@Test
	public void elFabricanteDelAireDebioSerLlamadoASuMetodoEncender() {
		sensor.laTemperaturaCambioA(25.0);
		Mockito.verify(fabricante, Mockito.times(1)).encenderDispositivo(aire.getIdDeFabrica());
	}
	
	@Test
	public void elAireDebeQuedarApagado() {
		sensor.laTemperaturaCambioA(23.2);
		Assert.assertEquals(Apagado.class, aire.getEstado().getClass());
	}
	
	@Test
	public void laTemperaturaDebioBajar3Grados() {
		sensor.laTemperaturaCambioA(25.0);
		Mockito.verify(fabricante, Mockito.times(1)).bajarTemperatura(aire.getIdDeFabrica(), 3);
	}

}
