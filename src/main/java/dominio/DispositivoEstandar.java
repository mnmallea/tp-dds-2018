package dominio;

public class DispositivoEstandar {
	private Float consumoPorHora;
	private Float horasDeUsoDiarias;

	public DispositivoEstandar(Float consumoPorHora, Float horasDeUsoDiarias) {
		this.consumoPorHora = consumoPorHora;
		this.horasDeUsoDiarias = horasDeUsoDiarias;
	}

	public Float getConsumoPorHora() {
		return this.consumoPorHora;
	}
	
	public void convertirEnInteligente() {
		
	}
	
	public Float getConsumo() {
		return this.consumoPorHora * this.horasDeUsoDiarias * 30;
	}

}
