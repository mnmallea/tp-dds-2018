package dominio;

import org.hibernate.annotations.Type;
import puntos.Point;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Direccion {

    @Embedded
    private Point coordenada;

    public void setCoordenada(Point coordenada) {
        this.coordenada = coordenada;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    @Type(type="org.hibernate.type.StringNVarcharType")
    private String domicilio;

    public Direccion(Point coordenada, String domicilio) {
        this.coordenada = coordenada;
        this.domicilio = domicilio;
    }

    public Direccion() {
    }

    public Point getCoordenada() {
        return coordenada;
    }

}
