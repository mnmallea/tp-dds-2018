package dominio;

import java.time.Period;

public interface Fabricante {

	Float consumoEnPeriodo(Period periodo, Long idDeFabrica);

	Float consumoEnUltimasHoras(int unasHoras, Long idDeFabrica);

	void apagarDispositivo(Long idDeFabrica);

	void encenderDispositivo(Long idDeFabrica);

	void ahorrarEnergia(Long idDeFabrica);
	
}
