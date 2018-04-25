package dominio;

public class Dispositivo {
	private Boolean encendido;
	private String nombre;
	private Double consumoPorHora;
	
	public void setEncendido(Boolean encendido) {
		this.encendido = encendido;
	}
	

	public Dispositivo(String nombre, Double consumoPorHora) {
		super();
		this.nombre = nombre;
		this.consumoPorHora = consumoPorHora;
	}



	public Boolean getEncedido(){
		return this.encendido;
	}
	
}
