package dominio;

import puntos.Point;
import repositorios.AdministradorClientes;
import repositorios.AdministradorTransformadores;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;

@Entity
public class Zona {

    private List<Transformador> transformadores;
    @OneToMany(mappedBy = "clientes")
    private List<Cliente> clientes;
    private Double radio;
    private Point centro;

    public Zona(Double radio, Point centro) {
        this.transformadores = AdministradorTransformadores.instancia.inicializarTransformadores(this);
        this.radio = radio;
        this.centro = centro;
        this.clientes = AdministradorClientes.instancia.inicializarClientes(this);
    }

    public Zona() {
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

    public void setTransformadores(List<Transformador> transformadores) {
        this.transformadores = transformadores;
    }

    @GeneratedValue
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
