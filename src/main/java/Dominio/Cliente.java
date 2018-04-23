package Dominio;


import java.util.List;
import org.joda.time.LocalDate;

public class Cliente {
	public Float consumoMesAnterior;
	public Float consumoUltimoMes;
	
	private String nombre;
	private String apellido;
	private TipoDocumento tipoDocumento;
	private Integer nroDocumento;
	private Integer nroTelefono;
	private String domicilio;
	private LocalDate fechaAlta;
	private Categoria categoria;
	private List<Dispositivo> dispositivos;
	// private String nombreUsuario;
	// private String contrasenia;
	
	//Tipos de categoria que puede adoptar un cliente
	static final Categoria r1 = new Categoria(18.76f, 0.644f);
	static final Categoria r2 = new Categoria(35.32f, 0.644f);
	static final Categoria r3 = new Categoria(60.71f, 0.681f);
	static final Categoria r4 = new Categoria(71.74f, 0.738f);
	static final Categoria r5 = new Categoria(110.38f, 0.794f);
	static final Categoria r6 = new Categoria(220.75f, 0.832f);
	static final Categoria r7 = new Categoria(443.59f, 0.851f);
	static final Categoria r8 = new Categoria(545.96f, 0.851f);
	static final Categoria r9 = new Categoria(887.19f, 0.851f);
	//-----------------------------------------------

	public Cliente(String nombre, String apellido, TipoDocumento tipoDocumento, Integer nroDocumento,
			Integer nroTelefono, String domicilio, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nroTelefono = nroTelefono;
		this.domicilio = domicilio;
		this.categoria = categoria;
	}

	// private void categorizar() {
	// this.categoria=this.categorias.stream().findAny(categoria->categoria.pertenece(this.consumoMensual)).get();
	// }
	
	/* private void categorizar(Float consumoMesAnterior) { 
	  // Determina la categoria a la que pertenece el cliente segun el consumo del mes anterior
 
	 * Para esta entrega podriamos asumir que la categoria viene determinada
	 * cuando se instancia al cliente
	 * (Agrego -categoria- al constructor)

	} */

	/*
	 * Con respecto a estos requerimientos del cliente, para mi, podriamos solamente
	 * usar este metodo.
	 * 
	 * â—� Saber la cantidad de dispositivos encendidos: es la funcion que defini â—�
	 * Saber la cantidad de dispositivos apagados: le haces el size a la lista de
	 * dispositivos, y le restas los que estan prendidos con el metodo que hice
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
