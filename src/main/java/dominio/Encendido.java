package dominio;

public class Encendido implements Estado {
	

	public void apagarse(DispositivoInteligente dispositivo) {
		dispositivo.apagarsePosta();
		dispositivo.setEstado(new Apagado());
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
}
