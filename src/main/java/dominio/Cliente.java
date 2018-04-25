package dominio;

import java.util.List;
import org.joda.time.LocalDate;

public class Cliente {
	public Float consumoMesAnterior;
	public Float consumoUltimoMes;

	private String nombre;
	private String apellido;
	private TipoDocumento tipoDocumento;
	private int nroDocumento;
	private Integer nroTelefono;
	private String domicilio;
	private LocalDate fechaAlta;
	private Categoria categoria;
	private List<Dispositivo> dispositivos;

	// private String nombreUsuario;
	// private String contrasenia;

	public List<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(List<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public Cliente(String nombre, String apellido, TipoDocumento tipoDocumento, Integer nroDocumento,
			Integer nroTelefono, String domicilio, Categoria categoria, List<Dispositivo> dispositivos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nroTelefono = nroTelefono;
		this.domicilio = domicilio;
		this.categoria = categoria;
		this.dispositivos = dispositivos;
	}

	public String getNombre() {
		return nombre;
	}

	public void categorizar(Float unConsumo) {
		this.categoria = Categorizador.getInstanceOf().getCategoriaSegunRango(unConsumo);
	}

	/*
	 * private void categorizar(Float consumoMesAnterior) { // Determina la
	 * categoria a la que pertenece el cliente segun el consumo del mes anterior
	 * 
	 * Para esta entrega podriamos asumir que la categoria viene determinada cuando
	 * se instancia al cliente (Agrego -categoria- al constructor)
	 * 
	 * }
	 */

	/*
	 * Con respecto a estos requerimientos del cliente, para mi, podriamos solamente
	 * usar este metodo.
	 * 
	 * â—� Saber la cantidad de dispositivos encendidos: es la funcion que defini
	 * â—� Saber la cantidad de dispositivos apagados: le haces el size a la lista
	 * de dispositivos, y le restas los que estan prendidos con el metodo que hice
	 * abajo
	 * 
	 * Igualmente, lo codeo, pero el viernes se lo pregunto porque simplificaria
	 * bastante el cÃ³digo
	 * 
	 */

	public Long cantidadDispositivosEncendidos() {
		return this.dispositivos.stream().filter(dispositivo -> dispositivo.getEncedido()).count();
	}

	public Long cantidadDispositivosApagados() {
		return this.dispositivos.stream().filter(dispositivo -> !dispositivo.getEncedido()).count();
	}

	public int cantidadDispositivos() {
		return this.dispositivos.size();
	}

	public Boolean algunDispositivoEncendido() {
		return this.dispositivos.stream().anyMatch(dispositivo -> dispositivo.getEncedido());
	}

	public Float montoEstimadoAPagar() {
		return categoria.facturaEstimada(consumoUltimoMes);
	}

}
