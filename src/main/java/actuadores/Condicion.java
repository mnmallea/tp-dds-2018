package actuadores;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "condicion")
public abstract class Condicion<T> {

    @GeneratedValue
    @Id
    private String id;

    abstract boolean seCumple(T medicion);

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
