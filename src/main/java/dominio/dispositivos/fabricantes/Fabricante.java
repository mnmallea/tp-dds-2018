package dominio.dispositivos.fabricantes;

import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public abstract class Fabricante {

	@GeneratedValue
	@Id
    private Long id;
	
    public abstract Float consumoEnPeriodo(Period periodo, Long idDeFabrica);

    public abstract Float consumoEnUltimasHoras(int unasHoras, Long idDeFabrica);

    public abstract void apagarDispositivo(Long idDeFabrica);

    public abstract void encenderDispositivo(Long idDeFabrica);

    public abstract void ahorrarEnergia(Long idDeFabrica);

    public abstract Float consumoUltimoMes(Long idDeFabrica);

}
