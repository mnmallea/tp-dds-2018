package dominio;

import java.time.Period;

public class DispositivoInteligente<T extends Fabricante> implements Dispositivo {

	private String nombre;
	private Estado estado;
	private Float consumoPorHora;
	private Float horasMinimas;
	private Float horasMaximas;
	private Float horasUsoMes;
	protected T fabricante;
	protected Long idDeFabrica;

	public DispositivoInteligente(String nombre, Estado estado, Float consumoPorHora, T fabricante, Long idDeFabrica) {
		this.nombre = nombre;
		this.estado = estado;
		this.consumoPorHora = consumoPorHora;
		this.fabricante = fabricante;
		this.idDeFabrica = idDeFabrica;
		this.horasUsoMes = 0f;
	}

	public T getFabricante() {
		return fabricante;
	}

	public void setFabricante(T fabricante) {
		this.fabricante = fabricante;
	}

	public Long getIdDeFabrica() {
		return idDeFabrica;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Float consumoEnHoras(int horas) {
		return horas * consumoPorHora;
	}

	public Float getConsumoPorHora() {
		return consumoPorHora;
	}

	public void setConsumoPorHora(Float consumoPorHora) {
		this.consumoPorHora = consumoPorHora;
	}

	public void apagarse() {
		estado.apagarse(this);
	}

	public void encenderse() {
		estado.encenderse(this);
	}

	public void ahorrarEnergia() {
		estado.ahorrarEnergia(this);
	}

	public Boolean estaEncendido() {
		return estado.estaEncendido();
	}

	public Boolean estaApagado() {
		return !estado.estaEncendido();
	}

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
		return fabricante.consumoUltimoMes(this.idDeFabrica);
	}

	public Estado getEstado() {
		return this.estado;
	}

	public Float getHorasMinimas() {
		return horasMinimas;
	}

	public Float getHorasMaximas() {
		return horasMaximas;
	}

	public void aumentarHorasPrendido(Float horasPrendido) {
		horasUsoMes += horasPrendido;	
	}

	@Override
	public Float getHorasUsoMes() {
		return this.horasUsoMes;
	}

}
