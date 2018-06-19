package tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import actuadores.Actuador;
import actuadores.Regla;
import actuadores.ReglaEnciendeAC;
import actuadores.Sensor;
import actuadores.SensorTemperatura;

public class EncenderAireTest {

	private Actuador actuadorEnciendeAire;
	private Regla<Double> reglaEnciendeAire;
	private Sensor<Double> sensorTemperatura;

	
	@Before
	public void init() {
		sensorTemperatura = new SensorTemperatura();
		actuadorEnciendeAire = Mockito.mock(Actuador.class);
		reglaEnciendeAire = new ReglaEnciendeAC(sensorTemperatura, actuadorEnciendeAire);
	}

	@Test
	public void laReglaSeEjecuta() {
		this.reglaEnciendeAire.ejecutarse();
		Mockito.verify(actuadorEnciendeAire, Mockito.calls(1));
	}

}
