package dominio;

import puntos.Point;

public class Direccion {
    private Point coordenada;
    private String domicilio;

    public Direccion(Point coordenada, String domicilio) {
        this.coordenada = coordenada;
        this.domicilio = domicilio;
    }

    public Point getCoordenada() {
        return coordenada;
    }

}
