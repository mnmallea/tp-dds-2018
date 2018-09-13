package actuadores;

import dominio.dispositivos.DispositivoInteligente;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoActuador")
public abstract class Actuador<T extends DispositivoInteligente<?>> {
    @GeneratedValue
    @Id
    private String id;

    public abstract void actuaSobre(T unDispositivo);

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
