package dominio;

public class AhorroEnergia implements Estado {

	public void apagarse(DispositivoInteligente dispositivo) {
		dispositivo.apagarsePosta();
		dispositivo.setEstado(new Apagado());
	}

	public void encenderse(DispositivoInteligente dispositivo) {
		dispositivo.encendersePosta();
		dispositivo.setEstado(new Encendido());
	}

	public void ahorrarEnergia(DispositivoInteligente dispositivo) {

	}

	public Boolean estaEncendido() {
		return true;
	}
}
