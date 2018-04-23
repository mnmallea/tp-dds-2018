package Dominio;

public class Dispositivo {
	private Boolean encendido;
	private String nombre;
	private Float consumoPorHora;
	
	

	public Dispositivo(String nombre, Float consumoPorHora) {
		super();
		this.nombre = nombre;
		this.consumoPorHora = consumoPorHora;
	}



	public Boolean getEncedido(){
		return this.encendido;
	}
}
