package actuadores;

public abstract class Regla <TipoMedicion> {
	private Sensor<TipoMedicion> sensor;
	private TipoMedicion medicion;
	private Actuador actuador;

	public Regla(Sensor<TipoMedicion> sensor, Actuador actuador) {
		this.sensor = sensor;
		this.actuador = actuador;
	}

	public void pedirMedicion() {
		this.medicion = sensor.tomarMedicion();
	}

	public abstract Boolean hayQueActuar(TipoMedicion medicion);

	public void ejecutarse() {
		this.pedirMedicion();
		if (this.hayQueActuar(this.medicion)) {
			actuador.actua();
		}
	}

}