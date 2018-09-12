package actuadores;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoSensor")
public class Sensor<T> {

    @GeneratedValue
    @Id
    private Long id;

    @ManyToMany
    private List<Regla<T, ?>> reglas;

    public Sensor(List<Regla<T, ?>> reglas) {
        this.reglas = reglas;
    }

    public Sensor() {
    }

    public void agregarRegla(Regla<T, ?> unaRegla) {
        reglas.add(unaRegla);
    }

    public void informarMedicion(T medicion) {
        reglas.forEach(regla -> regla.seTomoMedicion(medicion));
    }
}
