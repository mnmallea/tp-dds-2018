package dominio;

public class Dispositivo {
	private Boolean encendido = false;
	private String nombre;
	private Float consumoPorHora;
	
	public void setEncendido(Boolean encendido) {
		this.encendido = encendido;
	}
	
	public Dispositivo(String nombre, Float consumoPorHora) {
		this.nombre = nombre;
		this.consumoPorHora = consumoPorHora;
	}

	public Boolean getEncedido(){
		return this.encendido;
	}
	
	public Float getConsumoPorHora() {
		return this.consumoPorHora;
	}
}
