package actuadores;

import dominio.dispositivos.DispositivoInteligente;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoRegla")
public abstract class Regla<T, D extends DispositivoInteligente<?>> {
    @GeneratedValue
    @Id
    private Long id;

    public Condicion<T> getCondicion() {
        return condicion;
    }

    public void setCondicion(Condicion<T> condicion) {
        this.condicion = condicion;
    }

    @ManyToOne(targetEntity = Condicion.class, cascade = CascadeType.ALL)
    private Condicion<T> condicion;
    @ManyToMany(targetEntity = Actuador.class, cascade = CascadeType.PERSIST)
    private List<Actuador<D>> actuadores;

    @ManyToOne(targetEntity = DispositivoInteligente.class)
    @JoinColumn(name = "dispositivo")
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
        if (seCumpleCondicion(medicion)) {
            actuadores.forEach(actuador -> actuador.actuaSobre(dispositivo));
        }
    }

    protected boolean seCumpleCondicion(T medicion) {
        return condicion.seCumple(medicion);
    }
}
