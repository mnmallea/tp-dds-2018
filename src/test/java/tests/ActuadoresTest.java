package tests;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import actuadores.Accion;
import actuadores.Medicion;
import actuadores.Regla;
import actuadores.Sensor;
import dominio.Apagado;
import dominio.DispositivoInteligente;
import dominio.Fabricante;

public class ActuadoresTest {
	
	private Regla regla;
	private Accion accion;
	private Fabricante fabricante;
	private DispositivoInteligente dispositivo;
	private Sensor sensor;
	private Medicion medicion;

	@Before
	public void init(){
		
		fabricante = Mockito.mock(Fabricante.class);
		dispositivo = new DispositivoInteligente("tele",new Apagado(), 30f, fabricante, 1l);
		sensor = Mockito.mock(Sensor.class);
		medicion = Mockito.mock(Medicion.class);
		Mockito.when(sensor.tomarMedicion()).thenReturn(medicion);
		Mockito.when(medicion.debeDesencadenarAccion()).thenReturn(true);
		regla = new Regla(Arrays.asList(sensor));
		accion = Mockito.mock(Accion.class);		
		medicion.setDispositivo(dispositivo);
	}
	
	@Test
	public void seDebeDesencadenarLaAccionPorqueLaMedicionCumpleLaCondicionDebida() {
		regla.setMediciones();
		regla.dispararAcciones();
		Mockito.verify(accion, Mockito.times(1)).aplicarseA(dispositivo);;
	}


}
