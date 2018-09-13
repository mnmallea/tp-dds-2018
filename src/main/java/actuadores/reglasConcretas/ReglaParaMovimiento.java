package actuadores.reglasConcretas;

import actuadores.Actuador;
import actuadores.Condicion;
import actuadores.Regla;
import dominio.dispositivos.DispositivoInteligente;
import dominio.dispositivos.ReflectorInteligente;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue(value = "RPM")
public class ReglaParaMovimiento extends Regla<Boolean, ReflectorInteligente> implements ReglaParaMovimientoFabricante {
    public ReglaParaMovimiento(List<Actuador<ReflectorInteligente>> actuadores, ReflectorInteligente dispositivo) {
        super(null, actuadores, dispositivo);
    }

    public ReglaParaMovimiento() {
    }

    @Override
    public void huboMovimiento() {
        this.seTomoMedicion(true);
    }

    @Override
    protected boolean seCumpleCondicion(Boolean medicion) {
        return true;
    }
}
