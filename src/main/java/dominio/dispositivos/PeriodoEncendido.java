package dominio.dispositivos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "HistorialEncendidos")
public class PeriodoEncendido {
    private LocalDateTime inicio;
    private LocalDateTime fin;

    public PeriodoEncendido(LocalDateTime inicio, LocalDateTime fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public PeriodoEncendido() {
    }

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
