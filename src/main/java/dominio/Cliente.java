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
	private List<DispositivoInteligente> dispositivosInteligentes;
	private List<DispositivoEstandar> dispositivosEstandar;
	private int puntos = 0;

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public List<DispositivoInteligente> getDispositivosInteligentes() {
		return dispositivosInteligentes;
	}

	public void setDispositivosInteligentes(List<DispositivoInteligente> dispositivos) {
		this.dispositivosInteligentes = dispositivos;
	}

	public Cliente(String nombre, String apellido, TipoDocumento tipoDocumento, Integer nroDocumento,
			Integer nroTelefono, String domicilio, Categoria categoria, List<DispositivoInteligente> dispositivosInteligentes, LocalDate fechaAlta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nroTelefono = nroTelefono;
		this.domicilio = domicilio;
		this.dispositivosInteligentes = dispositivosInteligentes;
		this.fechaAlta = fechaAlta;
	}

	public String getNombre() {
		return nombre;
	}

	public Float consumo() { // Es la suma de cada uno de los consumos de sus dispositivos
		return this.dispositivosInteligentes.stream().map(dispositivo -> dispositivo.getConsumo())
				.reduce(0f, (unConsumo, otroConsumo) -> unConsumo + otroConsumo);
	}

	public void categorizar() {
		this.categoria = Categorizador.instancia.getCategoriaSegunRango(this.consumo());
	}

	public long cantidadDispositivosInteligentesEncendidos() {
		return this.dispositivosInteligentes.stream().filter(dispositivo -> dispositivo.estaEncendido()).count();
	}

	public long cantidadDispositivosInteligentesApagados() {
		return this.dispositivosInteligentes.stream().filter(dispositivo -> !dispositivo.estaEncendido()).count();
	}

	public int cantidadDispositivosEstandar() {
		return this.dispositivosEstandar.size();
	}
	
	public int cantidadDispositivosInteligentes() {
		return this.dispositivosEstandar.size();
	}
	
	public int cantidadDeDispositivos() {
		return this.cantidadDispositivosEstandar() + this.cantidadDispositivosInteligentes();
	}

	public Boolean algunDispositivoEncendido() {
		return this.dispositivosInteligentes.stream().anyMatch(dispositivo -> dispositivo.estaEncendido());
	}

	public Float montoEstimadoAPagar() {
		return categoria.facturaEstimada(this.consumo());
	}

	public void sumarPuntos(int unosPuntos) {
		this.puntos  += unosPuntos;
	}

}
