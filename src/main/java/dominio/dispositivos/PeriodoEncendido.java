package dominio.dispositivos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "HistorialEncendidos")
public class PeriodoEncendido {
    private LocalDateTime inicio;
    private LocalDateTime fin;
    @Id
    @GeneratedValue
    private Long id;

    public PeriodoEncendido(LocalDateTime inicio, LocalDateTime fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public PeriodoEncendido() {
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
}
