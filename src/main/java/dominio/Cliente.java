package dominio;

import java.util.List;

import org.joda.time.DateTime;
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
	private DateTime fechaAlta;
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
			Integer nroTelefono, String domicilio, Float consumoMesAnterior, List<Dispositivo> dispositivos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nroTelefono = nroTelefono;
		this.domicilio = domicilio;
		this.consumoMesAnterior = consumoMesAnterior;
		this.dispositivos = dispositivos;
	}

	public String getNombre() {
		return nombre;
	}

	public void categorizar() {
		this.categoria = Categorizador.getInstanceOf().getCategoriaSegunRango(consumoMesAnterior);
	}
	
	// Para Test
	public Categoria getCategoria() {
		return categoria;
	}

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
