package dominio;

import java.time.LocalDate;
import java.time.Period;

public class DispositivoInteligente implements TipoDispositivo {
	private Estado estado;
	private Float consumoPorHora;
	private Fabricante fabricante;
	private Long idDeFabrica;//entiendo que este seria como un numero de serie unico para cada dispositivo

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Float consumoEnHoras(int horas) {
		return horas * consumoPorHora;
	}

	@Override
	public void apagarse() {
		estado.apagarse(this);
	}

	@Override
	public void encenderse() {
		estado.encenderse(this);
	}

	@Override
	public void ahorrarEnergia() {
		estado.ahorrarEnergia(this);
	}

	@Override
	public Boolean estaEncendido() {
		return estado.estaEncendido();
	}

	@Override
	public Boolean estaApagado() {
		return !estado.estaEncendido();
	}

	@Override
	public Float consumoEnPeriodo(Period periodo) {
		return fabricante.consumoEnPeriodo(periodo, this.idDeFabrica);
	}
	
	public Float consumoEnUltimasHoras(int unasHoras) {
		return fabricante.consumoEnUltimasHoras(unasHoras, this.idDeFabrica);
	}

	public void apagarsePosta() {
		fabricante.apagarDispositivo(this.idDeFabrica);
	}

	public void encendersePosta() {
		fabricante.encenderDispositivo(this.idDeFabrica);
	}

	public void ahorrarEnergiaPosta() {
		fabricante.ahorrarEnergia(this.idDeFabrica);
	}

	public Float getConsumo() {
		return this.consumoEnPeriodo(Period.between(LocalDate.now().minusMonths(1),LocalDate.now()));
	}
}
