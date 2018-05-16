package dominio;

public abstract class Estado {

    public void apagarse(TipoDispositivo dispositivo) {
    	dispositivo.setEstado(new Apagado());
    }
    public void encenderse(TipoDispositivo dispositivo) {
    	dispositivo.setEstado(new Encendido());
    }
    public void ahorrarEnergia(TipoDispositivo dispositivo) {
    	dispositivo.setEstado(new AhorroEnergia());
    }
    public Boolean estaEncendido() {
    	return false;
    }

}
