package actuadores.condicionesConcretas;

import actuadores.Condicion;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "TMA")
public class TemperaturaMayorA extends Condicion<Double> {
    private Double temperatura;

    public TemperaturaMayorA(Double temperatura) {
        this.temperatura = temperatura;
    }

    public TemperaturaMayorA() {
    }

    @Override
    public boolean seCumple(Double medicion) {
        return medicion > this.temperatura;
    }
}
