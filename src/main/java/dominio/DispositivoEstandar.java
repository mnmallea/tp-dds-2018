package dominio;

public class DispositivoEstandar {
	private String nombre;
	private Float consumoPorHora;
	private Float horasDeUsoDiarias;
	private Long numeroDeSerie;

	public DispositivoEstandar(String nombre, Float consumoPorHora, Float horasDeUsoDiarias) {
		this.nombre = nombre;
		this.consumoPorHora = consumoPorHora;
		this.horasDeUsoDiarias = horasDeUsoDiarias;
	}
	
	public String getNombre() {
		return nombre;
	}

	public Float getConsumoPorHora() {
		return this.consumoPorHora;
	}
	
	public Float getConsumo() {
		return this.consumoPorHora * this.horasDeUsoDiarias * 30;
	}
	
	public String getNombre() {
		return nombre;
	}

	public Long getNumeroDeSerie() {
		return numeroDeSerie;
	}
}
