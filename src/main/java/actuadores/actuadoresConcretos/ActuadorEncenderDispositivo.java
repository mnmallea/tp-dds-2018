package actuadores.actuadoresConcretos;

import actuadores.Actuador;
import dominio.dispositivos.DispositivoInteligente;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "E")
public class ActuadorEncenderDispositivo<T extends DispositivoInteligente> extends Actuador {

    @Override
    public void actuaSobre(DispositivoInteligente unDispositivo) {
        unDispositivo.encenderse();
    }
}
