package dominio.estados;

import dominio.dispositivos.DispositivoInteligente;

import java.time.Duration;
import java.time.LocalDateTime;

public class Encendido implements Estado {
	private LocalDateTime horaALaQueSePrendio;
	
	

	public Encendido() {
		this.horaALaQueSePrendio = LocalDateTime.now();
	}

	public void apagarse(DispositivoInteligente dispositivo) {
		dispositivo.apagarsePosta();
		dispositivo.setEstado(new Apagado());
		dispositivo.aumentarHorasPrendido(this.horasPrendido());
	}

	private Float horasPrendido() {
		return Duration.between(horaALaQueSePrendio, LocalDateTime.now()).getSeconds() / 3600f;
	}

	public void encenderse(DispositivoInteligente dispositivo) {

	}

	public void ahorrarEnergia(DispositivoInteligente dispositivo) {
		dispositivo.ahorrarEnergiaPosta();
		dispositivo.setEstado(new AhorroEnergia());
	}

	public Boolean estaEncendido() {
		return true;
	}

	@Override
	public Boolean estaApagado() {
		return false;
	}

	@Override
	public Boolean estaAhorroEnergia() {
		return false;
	}
}