package dominio.estados;

import dominio.dispositivos.DispositivoInteligente;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue(value = "A")
public class Apagado extends Estado {

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
}
