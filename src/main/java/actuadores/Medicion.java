package actuadores;

import dominio.DispositivoInteligente;

public abstract class Medicion {
	private Accion accionQueDebeDesencadenar;
	private DispositivoInteligente dispositivo;

	public Medicion(Accion accionQueDebeDesencadenar, DispositivoInteligente dispositivo) {
		this.accionQueDebeDesencadenar = accionQueDebeDesencadenar;
		this.dispositivo = dispositivo;
	}

	public abstract Boolean debeDesencadenarAccion();

	public void desencadenarAccionSiDebe() {
		this.accionQueDebeDesencadenar.aplicarseA(this.dispositivo);
	}
}
