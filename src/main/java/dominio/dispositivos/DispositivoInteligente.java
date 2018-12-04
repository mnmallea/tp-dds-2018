package dominio.dispositivos;

import converter.EstadoConverter;
import converter.LocalDateTimeAttributeConverter;
import dominio.dispositivos.fabricantes.Fabricante;
import dominio.estados.Estado;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorColumn(name = "tipoDI")
public class DispositivoInteligente<T extends Fabricante> extends Dispositivo {

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Fabricante.class)
    protected T fabricante;
    @GeneratedValue
    @Id
    private Long id;
    protected Long idDeFabrica;
    private String nombre;
    @Convert(converter = EstadoConverter.class)
    private Estado estado;
    private Float consumoPorHora;
    private Float horasMinimas;
    private Float horasMaximas;
    private Float horasUsoMes;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "dispositivo")
    private List<Periodo> periodosEncendido;
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime ultimaHoraDeEncendido;

    public DispositivoInteligente(String nombre, Estado estado, Float consumoPorHora, T fabricante, Long idDeFabrica) {
        this.nombre = nombre;
        this.estado = estado;
        this.consumoPorHora = consumoPorHora;
        this.fabricante = fabricante;
        this.idDeFabrica = idDeFabrica;
        this.horasUsoMes = 0f;
        this.periodosEncendido = new ArrayList<>();
    }

    public DispositivoInteligente() {
    }

    public void setUltimaHoraDeEncendido(LocalDateTime ultimaHoraDeEncendido) {
        this.ultimaHoraDeEncendido = ultimaHoraDeEncendido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Periodo> getPeriodosEncendido() {
        return periodosEncendido;
    }

    public void agregarPeriodo(Periodo periodoEncendido) {
        periodosEncendido.add(periodoEncendido);
    }

    public T getFabricante() {
        return fabricante;
    }

    public void setFabricante(T fabricante) {
        this.fabricante = fabricante;
    }

    public Long getIdDeFabrica() {
        return idDeFabrica;
    }

    public Float consumoEnHoras(int horas) {
        return horas * consumoPorHora;
    }

    public Float getConsumoPorHora() {
        return consumoPorHora;
    }

    public void setConsumoPorHora(Float consumoPorHora) {
        this.consumoPorHora = consumoPorHora;
    }

    public void apagarse() {
        estado.apagarse(this);
    }

    public void encenderse() {
        estado.encenderse(this);
    }

    public void ahorrarEnergia() {
        estado.ahorrarEnergia(this);
    }

    public Boolean estaEncendido() {
        return estado.estaEncendido();
    }

    public Boolean estaApagado() {
        return !estado.estaEncendido();
    }

    public Float consumoEnPeriodo(Periodo periodo) {
        return periodo.enHoras() * this.consumoPorHora;
    }

    public double consumoEnPeriodo(LocalDateTime inicio, LocalDateTime fin) {
        return periodosEncendido.stream().filter(p -> p.incluidoEn(inicio, fin)).mapToDouble(Periodo::enHoras).sum()
                * this.consumoPorHora;
    }

    public Float consumoTotal() {
        return (float) periodosEncendido.stream().mapToDouble(this::consumoEnPeriodo).sum();
    }

    public Float consumoEnUltimasHoras(int unasHoras) {
        return fabricante.consumoEnUltimasHoras(unasHoras, this.idDeFabrica);
    }

    public void apagarsePosta() {
        fabricante.apagarDispositivo(this.idDeFabrica);
    }

    public Float consumoPromedio() {

        return this.consumoTotal() / this.getPeriodosEncendido().size();
    }

    public void encendersePosta() {
        fabricante.encenderDispositivo(this.idDeFabrica);
    }

    public void ahorrarEnergiaPosta() {
        fabricante.ahorrarEnergia(this.idDeFabrica);
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Float getHorasMinimas() {
        return horasMinimas;
    }

    @Override
    public void setHorasMinimas(Float horasMinimas) {
        this.horasMinimas = horasMinimas;
    }

    public Float getHorasMaximas() {
        return horasMaximas;
    }

    @Override
    public void setHorasMaximas(Float horasMaximas) {
        this.horasMaximas = horasMaximas;
    }

    public void aumentarHorasPrendido(Float unasHoras) {
        horasUsoMes += unasHoras;
    }

    @Override
    public Float getHorasUsoMes() {
        return this.horasUsoMes;
    }

    public void completarPeriodoEncendido() {
        final LocalDateTime NOW = LocalDateTime.now();
        Float horasPrendido = Duration.between(ultimaHoraDeEncendido, NOW).getSeconds() / 3600f;
        this.aumentarHorasPrendido(horasPrendido);
        this.agregarPeriodo(new Periodo(this.ultimaHoraDeEncendido, NOW));
    }

    public Long getId() {
        return id;
    }

    public double cantidadDeHorasEncendido() {
        return periodosEncendido.stream().mapToDouble(p -> p.enHoras()).sum();

    }
}
