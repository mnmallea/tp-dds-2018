package dominio;

import java.util.List;
import java.time.LocalDate;

public class Cliente {
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

	public Categoria getCategoria() {
		return categoria;
	}

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
		this.dispositivos = dispositivos;
	}

	public String getNombre() {
		return nombre;
	}

	public void categorizar(Float unConsumo) {
		this.categoria = Categorizador.getInstanceOf().getCategoriaSegunRango(unConsumo);
	}

	public long cantidadDispositivosEncendidos() {
		return this.dispositivos.stream().filter(dispositivo -> dispositivo.getEncedido()).count();
	}

	public long cantidadDispositivosApagados() {
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
