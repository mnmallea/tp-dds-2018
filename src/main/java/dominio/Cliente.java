package dominio;

import java.time.LocalDate;
import java.util.List;

public class Cliente {
	private String nombre;
	private String apellido;
	private TipoDocumento tipoDocumento;
	private int nroDocumento;
	private Integer nroTelefono;
	private String domicilio;
	private LocalDate fechaAlta;
	private Categoria categoria;
	private List<Dispositivo> dispositivos;

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

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
			Integer nroTelefono, String domicilio, Categoria categoria, List<Dispositivo> dispositivos, LocalDate fechaAlta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nroTelefono = nroTelefono;
		this.domicilio = domicilio;
		this.dispositivos = dispositivos;
		this.fechaAlta = fechaAlta;
	}

	public String getNombre() {
		return nombre;
	}

	public Float consumo() { // Es la suma de cada uno de los consumos de sus dispositivos
		return this.dispositivos.stream().map(dispositivo -> dispositivo.getConsumoPorHora())
				.reduce(0f, (unConsumo, otroConsumo) -> unConsumo + otroConsumo);
	}

	public void categorizar() {
		this.categoria = Categorizador.instancia.getCategoriaSegunRango(consumo());
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
		return categoria.facturaEstimada(consumo());
	}

}
