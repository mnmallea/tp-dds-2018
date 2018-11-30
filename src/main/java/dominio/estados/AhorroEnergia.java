package dominio.estados;

import java.time.LocalDateTime;

import dominio.dispositivos.DispositivoInteligente;

public class AhorroEnergia implements Estado {

	public void apagarse(DispositivoInteligente dispositivo) {
		dispositivo.apagarsePosta();
		dispositivo.setEstado(new Apagado());
	}

	public void encenderse(DispositivoInteligente dispositivo) {
		dispositivo.encendersePosta();
		dispositivo.setEstado(new Encendido());
		dispositivo.setUltimaHoraDeEncendido(LocalDateTime.now());
	}

	public void ahorrarEnergia(DispositivoInteligente dispositivo) {

	}

	public Boolean estaEncendido() {
		return true;
	}

	public Boolean estaApagado() {
		return false;
	}

	public Boolean estaAhorroEnergia() {
		return true;
	}

	@Override
	public String toString() {
		return "Ahorro energia";
	}
}
