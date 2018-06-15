package actuadores;

public class ReglaEnciendeAC extends Regla {

	public ReglaEnciendeAC(Sensor sensor, Actuador actuador) {
		super(sensor, actuador);
	}

	@Override
	public Boolean hayQueActuar(Double medicion) {
		return medicion > 24;
	}

}
