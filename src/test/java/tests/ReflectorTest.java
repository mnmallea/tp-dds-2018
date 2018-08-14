package tests;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import actuadores.Actuador;
import actuadores.ActuadorEncenderDispositivo;
import actuadores.ActuadorSubirIntensidadReflector;
import actuadores.ReglaParaMovimiento;
import actuadores.SensorMovimiento;
import dominio.dispositivos.ReflectorInteligente;
import dominio.estados.Apagado;
import dominio.dispositivos.DispositivoInteligente;
import dominio.estados.Encendido;
import dominio.dispositivos.fabricantes.FabricanteReflector;


public class ReflectorTest {

	private Actuador<?> actuadorEnciendeReflector;
	private Actuador<?> actuadorAumentarIntensidadLuminica;
	private ReglaParaMovimiento reglaParaReflector; // lo enciende y le aumenta la intensidad
	private DispositivoInteligente reflector;
	private FabricanteReflector fabricante;
	private SensorMovimiento sensor;
	
	@Before
	public void init() {
		fabricante = Mockito.mock(FabricanteReflector.class);
		reflector = new ReflectorInteligente("Reflector LG de patio", new Apagado(), 65.0f, fabricante, 1l);
		actuadorEnciendeReflector = new ActuadorEncenderDispositivo();
		actuadorAumentarIntensidadLuminica = new ActuadorSubirIntensidadReflector(10.0);
		reglaParaReflector= new ReglaParaMovimiento(reflector, Arrays.asList(actuadorEnciendeReflector, actuadorAumentarIntensidadLuminica));
		sensor = new SensorMovimiento(Arrays.asList(reglaParaReflector));
		
	}
	
	@Test
	public void elReflectorSeDebeEncender() {
		sensor.seMovio();
		Assert.assertEquals(Encendido.class, reflector.getEstado().getClass());
	}
	
	@Test
	public void elFabricanteDelReflectorDebioSerLlamadoASuMetodoEncender() {
		sensor.seMovio();
		Mockito.verify(fabricante, Mockito.times(1)).encenderDispositivo(reflector.getIdDeFabrica());
	}
		
	@Test
	public void laIntensidadLuminicaDebioSubir10Lux() {
		sensor.seMovio();;
		Mockito.verify(fabricante, Mockito.times(1)).aumentarIntensidad(reflector.getIdDeFabrica(), 10.0);
	}

}
