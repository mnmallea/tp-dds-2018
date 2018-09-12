package actuadores;

import dominio.dispositivos.DispositivoInteligente;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@DiscriminatorValue(value = "RT")
public class ReglaParaTemperatura extends Regla implements ReglaParaTemperaturaFabricante {

    @ManyToOne
    private DispositivoInteligente dispositivo;
    @ManyToMany
    private List<Actuador> actuadores;


    public ReglaParaTemperatura(DispositivoInteligente dispositivo, List<Actuador> actuadores) {
        this.dispositivo = dispositivo;
        this.actuadores = actuadores;
    }

    public ReglaParaTemperatura() {
    }

    @Override
    public void temperaturaCambioA(Double temperatura) {
        if (temperatura > 24) {
            actuadores.forEach(ac -> ac.actuaSobre(dispositivo));
        }
    }

}
