package dominio;

import java.time.Period;

public class DispositivoInteligente implements TipoDispositivo {
	private Estado estado;
	private Float consumoPorHora;

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Float consumoEnHoras(int horas) {
		return horas * consumoPorHora;
	}

	/*
	 * Para mi esto es medio en vano, porque tenemos el consumo en n horas, que
	 * seria lo mismo que en un periodo public Float consumoEnPeriodo(int empezo,
	 * int termino){ int horas = termino - empezo; return
	 * this.consumoEnHoras(horas); }
	 */
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
		return !this.estaEncendido();
	}

	@Override
	public Float consumoEnPeriodo(Period periodo) {
		// TODO Auto-generated method stub
		return null;
	}

}
