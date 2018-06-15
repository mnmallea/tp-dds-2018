package actuadores;

public abstract class Regla {
	private Sensor sensor;
	private Double medicion;
	private Actuador actuador;

	public Regla(Sensor sensor, Actuador actuador) {
		this.sensor = sensor;
		this.actuador = actuador;
	}

	public void pedirMedicion() {
		this.medicion = sensor.tomarMedicion();
	}

	public abstract Boolean hayQueActuar(Double medicion);

	public void ejecutarse() {
		this.pedirMedicion();
		if (this.hayQueActuar(this.medicion)) {
			actuador.actua();
		}
	}

}