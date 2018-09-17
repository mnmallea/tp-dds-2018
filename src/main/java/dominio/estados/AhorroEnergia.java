package dominio.estados;

import dominio.dispositivos.DispositivoInteligente;

import java.time.LocalDateTime;


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
}
