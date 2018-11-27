package dominio;

import puntos.Point;
import repositorios.AdministradorClientes;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Transformador {
    @Embedded
    private Point coordenadas;
    @OneToMany
    @JoinColumn(name = "transformador")
    private List<Cliente> clientes;

    @GeneratedValue
    @Id
    private Long id;
    private Long idEnre;

    public Transformador(Point coordenadas) {
        this.coordenadas = coordenadas;
        this.clientes = AdministradorClientes.instancia.obtenerClientesDeTransformador(this);
    }

    public Transformador() {
    }

    public Long getIdEnre() {
        return idEnre;
    }

    public Point getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Point coordenadas) {
        this.coordenadas = coordenadas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Double energiaSuministrada() {
        return this.clientes.stream().mapToDouble(Cliente::consumo).sum();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double consumoTotal(LocalDateTime inicio, LocalDateTime fin) {
        return clientes.stream().mapToDouble(c -> c.consumoDeDispositivosInteligentesEnPeriodo(inicio, fin)).sum();
    }

    public Double consumoPromedioEnPeriodo(LocalDateTime inicio, LocalDateTime fin) {
        return this.consumoTotal(inicio, fin) / this.getClientes().size();
    }

    @Override
    public String toString() {
        return "Transformador(id = " + this.id + ", idEnre = " + this.idEnre + ", posicion = " + this.coordenadas + ")";
    }
}

