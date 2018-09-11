package dominio;

import puntos.Point;
import repositorios.AdministradorClientes;
import repositorios.AdministradorTransformadores;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;

@Entity
public class Zona {
    @OneToMany(mappedBy = "zona")
    private List<Transformador> transformadores;

    @OneToMany(mappedBy = "zona")
    private List<Cliente> clientes;

    private Double radio;
    @Embedded
    private Point centro;
    @GeneratedValue
    @Id
    private String id;

    public Zona(Double radio, Point centro) {
        this.transformadores = AdministradorTransformadores.instancia.inicializarTransformadores(this);
        this.radio = radio;
        this.centro = centro;
        this.clientes = AdministradorClientes.instancia.inicializarClientes(this);
    }

    public Zona() {
    }

    public List<Transformador> getTransformadores() {
        return transformadores;
    }

    public void setTransformadores(List<Transformador> transformadores) {
        this.transformadores = transformadores;
    }

    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    public Point getCentro() {
        return centro;
    }

    public void setCentro(Point centro) {
        this.centro = centro;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Transformador transformadorMasCercanoA(Point coordenada) {
        return transformadores.stream().min(Comparator.comparingDouble(transformador -> coordenada.distance(transformador.getCoordenadas()))).get();
    }

    public void asignarClienteATransformador(Cliente cliente) {

        Transformador transformador = this.transformadorMasCercanoA(cliente.getDireccion().getCoordenada());

        transformador.agregarCliente(cliente);
    }

    public void asignarATransformadores() {
        this.clientes.forEach(this::asignarClienteATransformador);
    }

    public Double consumoTotal() {
        return transformadores.stream().mapToDouble(Transformador::energiaSuministrada).sum();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
