package dominio;

import puntos.Point;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Transformador {
    @Embedded
    private Point coordenadas;
    @OneToMany
    @JoinColumn(name = "transformador")
    private List<Cliente> clientes;
    @ManyToOne
    private Zona zona;
    @GeneratedValue
    @Id
    private Long id;

    public Transformador(Point coordenadas) {
        this.coordenadas = coordenadas;
        this.clientes = new ArrayList<>();
    }

    public Transformador() {
    }

    public Point getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Point coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Zona getZona() {
        return this.zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
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
}

