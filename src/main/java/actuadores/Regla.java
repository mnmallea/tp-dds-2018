package actuadores;

import dominio.dispositivos.DispositivoInteligente;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoReglas")
public class Regla<T, D extends DispositivoInteligente<?>> {

    @GeneratedValue
    @Id
    private Long id;
    @ManyToOne
    private Condicion<T> condicion;
    @ManyToMany
    private List<Actuador<D>> actuadores;
    private D dispositivo;

    public Regla(Condicion<T> condicion, List<Actuador<D>> actuadores, D dispositivo) {
        this.condicion = condicion;
        this.actuadores = actuadores;
        this.dispositivo = dispositivo;
    }

    public Regla() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void seTomoMedicion(T medicion) {
        if (condicion.seCumple(medicion)) {
            actuadores.forEach(actuador -> actuador.actuaSobre(dispositivo));
        }
    }
}
