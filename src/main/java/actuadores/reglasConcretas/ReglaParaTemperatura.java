package actuadores.reglasConcretas;

import actuadores.Actuador;
import actuadores.Condicion;
import actuadores.Regla;
import actuadores.condicionesConcretas.TemperaturaMayorA;
import dominio.dispositivos.AireAcondicionadoInteligente;
import dominio.dispositivos.DispositivoInteligente;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue(value = "RT")
public class ReglaParaTemperatura extends Regla<Double, AireAcondicionadoInteligente> implements ReglaParaTemperaturaFabricante {
    public ReglaParaTemperatura(List<Actuador<AireAcondicionadoInteligente>> actuadores, AireAcondicionadoInteligente dispositivo) {
        super(new TemperaturaMayorA(24.0), actuadores, dispositivo);
    }

    public ReglaParaTemperatura() {
    }

    @Override
    public void temperaturaCambioA(Double temperatura) {
        this.seTomoMedicion(temperatura);
    }

}