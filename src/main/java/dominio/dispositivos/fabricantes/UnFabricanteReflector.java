package dominio.dispositivos.fabricantes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.Period;

@Entity
@DiscriminatorValue("FR")
public class UnFabricanteReflector extends FabricanteReflector {
    @Override
    public void aumentarIntensidad(Long idDeFabrica, Double unosLux) {

    }

    @Override
    public void disminuirIntensidad(Long idDeFabrica, Double unosLux) {

    }

    @Override
    public Float consumoEnPeriodo(Period periodo, Long idDeFabrica) {
        return null;
    }

    @Override
    public Float consumoEnUltimasHoras(int unasHoras, Long idDeFabrica) {
        return null;
    }

    @Override
    public void apagarDispositivo(Long idDeFabrica) {

    }

    @Override
    public void encenderDispositivo(Long idDeFabrica) {

    }

    @Override
    public void ahorrarEnergia(Long idDeFabrica) {

    }

    @Override
    public Float consumoUltimoMes(Long idDeFabrica) {
        return null;
    }
}
