package actuadores;

import dominio.DispositivoInteligente;

public abstract class Sensor {

	private DispositivoInteligente dispositivo;


	public Sensor(DispositivoInteligente dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	
	public abstract Medicion tomarMedicion();
	
}
