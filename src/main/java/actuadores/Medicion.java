package actuadores;

import dominio.Dispositivo;

public abstract class Medicion {
	private Accion accionQueDebeDesencadenar;
	private Dispositivo dispositivo;

	public Medicion(Accion accionQueDebeDesencadenar, Dispositivo dispositivo) {
		this.accionQueDebeDesencadenar = accionQueDebeDesencadenar;
		this.dispositivo = dispositivo;
	}

	public abstract Boolean debeDesencadenarAccion();

	public void desencadenarAccionSiDebe() {
		this.accionQueDebeDesencadenar.aplicarseA(this.dispositivo);
	}
}
