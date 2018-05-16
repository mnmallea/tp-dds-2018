package dominio;

public class Dispositivo {
	private String nombre;
	private Float consumoPorHora;
	private TipoDispositivo tipoDispositivo;
	
	public Dispositivo(String nombre, Float consumoPorHora) {
		this.nombre = nombre;
		this.consumoPorHora = consumoPorHora;
	}

	public Boolean estaEncendido(){
		return tipoDispositivo.estaEncendido();
	}
	
	public Float getConsumoPorHora() {
		return this.consumoPorHora;
	}
	
	
	public void convertirEnInteligente(Cliente unCliente) {
		this.tipoDispositivo = new DispositivoInteligente();
		unCliente.sumarPuntos(10);
	}
}
