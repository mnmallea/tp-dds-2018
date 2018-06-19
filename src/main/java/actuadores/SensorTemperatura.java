package actuadores;

public class SensorTemperatura implements Sensor <Double>{
	public Double tomarMedicion() {
		return new Double(25);
	}
	
}
