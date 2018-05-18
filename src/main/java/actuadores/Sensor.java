package actuadores;

import dominio.Dispositivo;

public interface Sensor {
	public Medicion realizarMedicion(Dispositivo unDispositivo);
	public void comunicarMedicion();
}
