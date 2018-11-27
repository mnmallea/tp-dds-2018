package actuadores.condicionesConcretas;

import actuadores.condicionesAbstractas.CondicionDouble;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "TemperaturaMayorA")
public class TemperaturaMayorA extends CondicionDouble {
    private Double valorDouble;

    public TemperaturaMayorA(Double temperatura) {
        this.valorDouble= temperatura;
    }

    public TemperaturaMayorA() {
    }

    @Override
    public boolean seCumple(Double medicion) {
        return medicion > this.valorDouble;
    }
}
