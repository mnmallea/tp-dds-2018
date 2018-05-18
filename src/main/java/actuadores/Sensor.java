package actuadores;

import dominio.DispositivoInteligente;

public interface Sensor {
	public Medicion realizarMedicion(DispositivoInteligente unDispositivo);
	public void comunicarMedicion();
}
