package dominio.dispositivos.fabricantes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.Period;

@Entity
@DiscriminatorValue(value = "U")
public class UnFabricante extends Fabricante {
    @Override
    public Float consumoEnPeriodo(Period periodo, Long idDeFabrica) {
        return 2.0f;
    }

    @Override
    public Float consumoEnUltimasHoras(int unasHoras, Long idDeFabrica) {
        return 3.0f;
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
        return 4.0f;
    }
}
