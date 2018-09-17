package dominio.estados;

import dominio.dispositivos.DispositivoInteligente;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "E")
public class Encendido extends Estado {

    public void encenderse(DispositivoInteligente dispositivo) {

    }

    public void apagarse(DispositivoInteligente dispositivo) {
        dispositivo.apagarsePosta();
        dispositivo.setEstado(new Apagado());
        dispositivo.completarPeriodoEncendido();
    }


    public void ahorrarEnergia(DispositivoInteligente dispositivo) {
        dispositivo.ahorrarEnergiaPosta();
        dispositivo.setEstado(new AhorroEnergia());
    }

    public Boolean estaEncendido() {
        return true;
    }

    public Boolean estaApagado() {
        return false;
    }

    public Boolean estaAhorroEnergia() {
        return false;
    }
}
