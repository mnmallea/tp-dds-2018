package actuadores;

import dominio.dispositivos.ReflectorInteligente;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "SIR")
public class ActuadorSubirIntensidadReflector extends Actuador<ReflectorInteligente> {
    private Double luxQueSube;

    public ActuadorSubirIntensidadReflector(Double luxQueSube) {
        this.luxQueSube = luxQueSube;
    }

    public ActuadorSubirIntensidadReflector() {
    }

    @Override
    public void actuaSobre(ReflectorInteligente unReflector) {
        unReflector.aumentarIntensidad(luxQueSube);
    }

}
