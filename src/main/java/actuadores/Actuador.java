package actuadores;

import dominio.dispositivos.DispositivoInteligente;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoActuador")
public abstract class Actuador<T extends DispositivoInteligente<?>> {
    @GeneratedValue
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public abstract void actuaSobre(T unDispositivo);
}
