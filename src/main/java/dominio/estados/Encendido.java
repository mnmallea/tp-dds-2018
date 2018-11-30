package dominio.estados;

import dominio.dispositivos.DispositivoInteligente;

public class Encendido implements Estado {

	public void encenderse(DispositivoInteligente dispositivo) {

	}

	public void apagarse(DispositivoInteligente dispositivo) {
		dispositivo.apagarsePosta();
		dispositivo.setEstado(new Apagado());
		dispositivo.completarPeriodoEncendido();
	}

	public void ahorrarEnergia(DispositivoInteligente dispositivo) {
		dispositivo.ahorrarEnergiaPosta();
		dispositivo.setEstado(new AhorroEnergia());
	}

	public Boolean estaEncendido() {
		return true;
	}

	public Boolean estaApagado() {
		return false;
	}

	public Boolean estaAhorroEnergia() {
		return false;
	}

	@Override
	public String toString() {
		return "Encendido";
	}
}
