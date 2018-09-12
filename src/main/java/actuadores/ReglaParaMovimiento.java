package actuadores;

import dominio.dispositivos.DispositivoInteligente;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue(value = "RM")
public class ReglaParaMovimiento extends Regla implements ReglaParaMovimientoFabricante {

    @ManyToOne
    private DispositivoInteligente dispositivo;
    @ManyToMany
    private List<Actuador> actuadores;

    public ReglaParaMovimiento(DispositivoInteligente dispositivo, List<Actuador> actuadores) {
        this.dispositivo = dispositivo;
        this.actuadores = actuadores;
    }

    public ReglaParaMovimiento() {
    }

    @Override
    public void huboMovimiento() {
        actuadores.forEach(actuador -> actuador.actuaSobre(dispositivo));
    }
}
