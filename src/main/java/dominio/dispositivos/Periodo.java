package dominio.dispositivos;

import converter.LocalDateTimeAttributeConverter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity(name = "HistorialEncendidos")
public class Periodo {
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime inicio;
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime fin;
    @Id
    @GeneratedValue
    private Long id;

    public Periodo(LocalDateTime inicio, LocalDateTime fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public Periodo() {
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public Long enHoras(){
        return ChronoUnit.HOURS.between(inicio, fin);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Inicio: " + this.inicio + "; Fin: " + this.fin;
    }

    public boolean incluidoEn(LocalDateTime inicio, LocalDateTime fin) {
        return (inicio.isBefore(this.inicio) && fin.isAfter(this.fin));
    }
}
