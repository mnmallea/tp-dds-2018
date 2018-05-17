package actuadores;

import dominio.Dispositivo;

public abstract class Sensor {
	public abstract Medicion realizarMedicion(Dispositivo unDispositivo);
	public abstract void comunicarMedicion();
}
