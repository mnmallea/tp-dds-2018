package actuadores;

import dominio.DispositivoInteligente;

public abstract class Medicion {
	private Accion accionQueDebeDesencadenar;
	private DispositivoInteligente dispositivo;

	public Medicion(Accion accionQueDebeDesencadenar, DispositivoInteligente dispositivo) {
		this.accionQueDebeDesencadenar = accionQueDebeDesencadenar;
		this.dispositivo = dispositivo;
	}
	
	
	public void setDispositivo(DispositivoInteligente unDispositivo) {
		this.dispositivo = unDispositivo;
	}
	

	public abstract Boolean debeDesencadenarAccion();

	public void dispararAccion() {
		if(this.debeDesencadenarAccion())
			accionQueDebeDesencadenar.aplicarseA(dispositivo);
	}
}
