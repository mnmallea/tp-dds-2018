package dominio.dispositivos.fabricantes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.Period;

@Entity
@DiscriminatorValue("FA")
public class UnFabricanteAire extends FabricanteAireAcondicionado {
    @Override
    public void subirTemperatura(Long idDeFabrica, Integer unosGrados) {

    }

    @Override
    public void bajarTemperatura(Long idDeFabrica, Integer unosGrados) {

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
        return 5f;
    }
}
