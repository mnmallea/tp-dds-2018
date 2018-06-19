package actuadores;

public class ReglaEnciendeAC extends Regla<Double> {

	public ReglaEnciendeAC(Sensor<Double> sensor, Actuador actuador) {
		super(sensor, actuador);
	}

	@Override
	public Boolean hayQueActuar(Double medicion) {
		return medicion > 24;
	}

}
