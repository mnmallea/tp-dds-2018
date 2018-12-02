package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Administrador extends Usuario {
    private String nombre;
    private String apellido;
    private LocalDate fechaAlta;
    @Column(unique = true)
    private Integer nroIdentificacion;

    public Administrador(String nombre, String apellido, LocalDate fechaAlta, Integer nroIdentificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaAlta = fechaAlta;
        this.nroIdentificacion = nroIdentificacion;
    }

    public Administrador() {
    }

    public int mesesDeAdministrador() {
        return Period.between(fechaAlta, LocalDate.now()).getMonths();
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNroIdentificacion() {
        return nroIdentificacion;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }


}

