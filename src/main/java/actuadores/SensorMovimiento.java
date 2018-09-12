package actuadores;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue(value = "SM")
public class SensorMovimiento extends Sensor implements SensorMovimientoFabricante {

    public SensorMovimiento(List<ReglaParaMovimiento> reglas) {
        this.reglas = reglas;
    }

    public SensorMovimiento() {
    }

    public void agregarRegla(ReglaParaMovimiento unaRegla) {
        reglas.add(unaRegla);
    }

    @Override
    public void seMovio() {
        reglas.forEach(ReglaParaMovimiento::huboMovimiento);
    }


}
