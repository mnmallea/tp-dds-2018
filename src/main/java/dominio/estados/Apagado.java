package dominio.estados;

import dominio.dispositivos.DispositivoInteligente;

public class Apagado implements Estado {

	public void apagarse(DispositivoInteligente dispositivo) {

	}

	public void encenderse(DispositivoInteligente dispositivo) {
		dispositivo.encendersePosta();
		dispositivo.setEstado(new Encendido());
	}

	public void ahorrarEnergia(DispositivoInteligente dispositivo) {
		dispositivo.ahorrarEnergiaPosta();
		dispositivo.setEstado(new AhorroEnergia());
	}

	public Boolean estaEncendido() {
		return false;
	}

	@Override
	public Boolean estaApagado() {
		return true;
	}

	@Override
	public Boolean estaAhorroEnergia() {
		return false;
	}
}
