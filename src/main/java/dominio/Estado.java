package dominio;

public interface Estado {

    public void apagarse(DispositivoInteligente dispositivo);
    public void encenderse(DispositivoInteligente dispositivo);
    public void ahorrarEnergia(DispositivoInteligente dispositivo);
    public Boolean estaEncendido();
}
