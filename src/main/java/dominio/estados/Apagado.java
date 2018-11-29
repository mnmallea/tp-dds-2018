package dominio.estados;

import dominio.dispositivos.DispositivoInteligente;

import java.time.LocalDateTime;


public class Apagado implements Estado {

    public void apagarse(DispositivoInteligente dispositivo) {

    }

    public void encenderse(DispositivoInteligente dispositivo) {
        dispositivo.encendersePosta();
        dispositivo.setEstado(new Encendido());
        dispositivo.setUltimaHoraDeEncendido(LocalDateTime.now());
    }

    public void ahorrarEnergia(DispositivoInteligente dispositivo) {
        dispositivo.ahorrarEnergiaPosta();
        dispositivo.setEstado(new AhorroEnergia());
    }

    public Boolean estaEncendido() {
        return false;
    }

    public Boolean estaApagado() {
        return true;
    }

    public Boolean estaAhorroEnergia() {
        return false;
    }

    @Override
    public String toString() {
        return "Apagado";
    }
}
