package dominio;

import dominio.dispositivos.Dispositivo;
import dominio.dispositivos.DispositivoEstandar;
import dominio.dispositivos.DispositivoInteligente;
import dominio.dispositivos.PeriodoEncendido;
import dominio.dispositivos.fabricantes.Fabricante;
import dominio.estados.Apagado;
import puntos.Point;
import simplex.EfectoSimplex;
import simplex.SolucionSimplex;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class Cliente {
    
	@GeneratedValue
    @Id
    private Long id;
    private String nombre;
    private String apellido;
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;
    private int nroDocumento;
    private Integer nroTelefono;
    private LocalDate fechaAlta;
    @ManyToOne
    private Categoria categoria;
    @OneToMany
    @JoinColumn(name = "cliente")
    private List<DispositivoInteligente> dispositivosInteligentes;
    @OneToMany
    @JoinColumn(name = "cliente")
    private List<DispositivoEstandar> dispositivosEstandar;
    private int puntos = 0;
    @Embedded
    private Direccion direccion;
    @Enumerated(EnumType.STRING)
    private EfectoSimplex efectoSimplex;
    public Cliente(String nombre, String apellido, TipoDocumento tipoDocumento, Integer nroDocumento,
                   Integer nroTelefono, Direccion direccion, Categoria categoria,
                   List<DispositivoInteligente> dispositivosInteligentes, List<DispositivoEstandar> dispositivosEstandar,
                   LocalDate fechaAlta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.nroTelefono = nroTelefono;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
        this.dispositivosEstandar = dispositivosEstandar;
        this.dispositivosInteligentes = dispositivosInteligentes;
    }
    public Cliente() {
    }

    public String getApellido() {
        return apellido;
    }

    public int getNroDocumento() {
        return nroDocumento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public void registrarDispositivoInteligente(DispositivoInteligente nuevoDispositivo) {
        dispositivosInteligentes.add(nuevoDispositivo);
        sumarPuntos(15);
    }

    public String getNombre() {
        return nombre;
    }

    public Float consumo() { 
        return (float) (this.consumoDispositivosEstandares() + this.consumoDispositivosInteligentes());
    }

    public Double consumoDispositivosInteligentes() {
        return this.dispositivosInteligentes.stream().mapToDouble(dispositivo -> dispositivo.getConsumo()).sum();
    }

    public Double consumoDispositivosEstandares() {
        return this.dispositivosEstandar.stream().mapToDouble(dispositivo -> dispositivo.getConsumo()).sum();
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
        return this.dispositivosInteligentes.size();
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
        this.puntos += unosPuntos;
    }

    public <T extends Fabricante> void convertirAInteligente(DispositivoEstandar unDispositivo, T unFabricante) {
        DispositivoInteligente nuevoDispositivo = new DispositivoInteligente<>(unDispositivo.getNombre(), new Apagado(),
                unDispositivo.getConsumoPorHora(), unFabricante, unDispositivo.getNumeroDeSerie());
        dispositivosInteligentes.add(nuevoDispositivo);
        dispositivosEstandar.remove(unDispositivo);

        this.sumarPuntos(10);
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

    public List<Dispositivo> getDispositivos() {
        return Stream.concat(this.dispositivosInteligentes.stream(), this.dispositivosEstandar.stream())
                .collect(Collectors.toList());
    }

    public void notificarResultadoSimplex(List<SolucionSimplex> soluciones) {
        soluciones.forEach(solucion -> solucion.aplicarEfectoSiDebe(this.efectoSimplex));
    }

    public Double consumoDeDispositivosInteligentesEnPeriodo(PeriodoEncendido periodoEncendido){
        return dispositivosInteligentes.stream().mapToDouble(d -> d.consumoEnPeriodo(periodoEncendido)).sum();
    }
    public Double consumoDeDispositivosInteligentesEnPeriodo(LocalDateTime inicio, LocalDateTime fin){
        return dispositivosInteligentes.stream().mapToDouble(d -> d.consumoEnPeriodo(inicio, fin)).sum();
    }
    
    public Double consumoTotalEnPeriodo(PeriodoEncendido periodo) {
    	return this.consumoDeDispositivosInteligentesEnPeriodo(periodo) + this.consumoDispositivosEstandares() * periodo.enHoras();
    }
    
    public Float  consumoPromedioPorDispositivo() {
    	return this.consumo() / this.cantidadDeDispositivos();
    }

    public Double distanciaA(Point unPunto){
        return getDireccion().getCoordenada().distance(unPunto);
    }
    
}
