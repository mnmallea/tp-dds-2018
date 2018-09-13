package actuadores.sensoresConcretos;

import actuadores.Regla;
import actuadores.Sensor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue(value = "ST")
public class SensorTemperatura extends Sensor<Double> implements SensorTemperaturaFabricante  {
    public SensorTemperatura(List<Regla<Double, ?>> reglas) {
        super(reglas);
    }

    public SensorTemperatura() {
    }

    @Override
    public void laTemperaturaCambioA(Double temperatura) {
        this.informarMedicion(temperatura);
    }
}
