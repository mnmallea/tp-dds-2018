package dominio.estados;

import dominio.dispositivos.DispositivoInteligente;


public interface Estado {

    void apagarse(DispositivoInteligente dispositivo);

    void encenderse(DispositivoInteligente dispositivo);

    void ahorrarEnergia(DispositivoInteligente dispositivo);

    Boolean estaEncendido();

    Boolean estaApagado();

    Boolean estaAhorroEnergia();

}
