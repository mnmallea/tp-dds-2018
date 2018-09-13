package actuadores.sensoresConcretos;

import actuadores.Regla;
import actuadores.Sensor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue(value = "SM")
public class SensorMovimiento extends Sensor<Boolean> implements SensorMovimientoFabricante{
    public SensorMovimiento(List<Regla<Boolean, ?>> reglas) {
        super(reglas);
    }

    public SensorMovimiento() {
    }

    public void seMovio() {
        this.informarMedicion(true);
    }


}
