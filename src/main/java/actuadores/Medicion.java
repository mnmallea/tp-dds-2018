package actuadores;

import dominio.Dispositivo;

public abstract class Medicion {
	private Accion accionQueDebeDesencadenar;
	private Dispositivo dispositivo;
	
	public abstract Boolean debeDesencadenarAccion();
	
	public void desencadenarAccionSiDebe() {
		this.accionQueDebeDesencadenar.aplicarseA(this.dispositivo);
	}
}
