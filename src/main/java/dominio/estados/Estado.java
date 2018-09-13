package dominio.estados;

import dominio.dispositivos.DispositivoInteligente;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoEstado")
public abstract class Estado {

    @GeneratedValue
    @Id
    private Long id;

    public abstract void apagarse(DispositivoInteligente dispositivo);

    public abstract void encenderse(DispositivoInteligente dispositivo);

    public abstract void ahorrarEnergia(DispositivoInteligente dispositivo);

    public abstract Boolean estaEncendido();

    public abstract Boolean estaApagado();

    public abstract Boolean estaAhorroEnergia();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
