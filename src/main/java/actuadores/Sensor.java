package actuadores;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoSensor")
public abstract class Sensor<T> {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(targetEntity = Regla.class)
    protected List<Regla<T, ?>> reglas;

    protected Sensor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sensor(List<Regla<T, ?>> reglas) {
        this.reglas = reglas;
    }

    public void agregarRegla(Regla<T, ?> unaRegla) {
        reglas.add(unaRegla);
    }

    public void informarMedicion(T medicion) {
        reglas.forEach(regla -> regla.seTomoMedicion(medicion));
    }
}
