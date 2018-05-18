package dominio;

public abstract class Estado {

    public void apagarse(DispositivoInteligente dispositivo) {
    	dispositivo.apagarsePosta();
    	dispositivo.setEstado(new Apagado());
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
}
