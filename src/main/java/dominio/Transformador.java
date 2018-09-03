package dominio;

import puntos.Point;

import java.util.ArrayList;
import java.util.List;

public class Transformador {
    private Point coordenadas;
    private List<Cliente> clientes;
    private Zona zona;

    public Transformador(Point coordenadas) {
        this.coordenadas = coordenadas;
        this.clientes = new ArrayList<>();
    }

    public Double energiaSuministrada() {
        return this.clientes.stream().mapToDouble(Cliente::consumo).sum();
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

