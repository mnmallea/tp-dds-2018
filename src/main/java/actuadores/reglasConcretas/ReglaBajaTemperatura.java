package actuadores.reglasConcretas;

import actuadores.Actuador;
import actuadores.Condicion;
import actuadores.Regla;
import dominio.dispositivos.AireAcondicionadoInteligente;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue(value = "RBT")
public class ReglaBajaTemperatura extends Regla<Double, AireAcondicionadoInteligente> {
    public ReglaBajaTemperatura(Condicion<Double> condicion, List<Actuador<AireAcondicionadoInteligente>> actuadores, AireAcondicionadoInteligente dispositivo) {
        super(condicion, actuadores, dispositivo);
    }

    public ReglaBajaTemperatura() {
    }
}
