package actuadores;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoCondicion")
public abstract class Condicion<T> {

    @GeneratedValue
    @Id
    private Long id;

    public abstract boolean seCumple(T medicion);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
