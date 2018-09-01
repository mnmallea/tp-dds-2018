package dominio;

import puntos.Point;

import java.util.List;

public class Transformador {
    private Point coordenadas;
    private List<Cliente> clientes;
    private Zona zona;

    public Transformador(Point coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Double energiaSuministrada() {
        return getClientes().stream().mapToDouble(Cliente::consumo).sum();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Point getCoordenadas() {
        return coordenadas;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Zona getZona() {
        return this.zona;
    }
}

