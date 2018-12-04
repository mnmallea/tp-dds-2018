package dominio.dispositivos.fabricantes;

import javax.persistence.*;
import java.time.Period;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
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
