package actuadores.actuadoresConcretos;

import actuadores.Actuador;
import dominio.dispositivos.DispositivoInteligente;
import dominio.dispositivos.fabricantes.Fabricante;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "AD")
public class ActuadorApagarDispositivo extends Actuador<DispositivoInteligente<? extends Fabricante>> {

    @Override
    public void actuaSobre(DispositivoInteligente unDispositivo) {
        unDispositivo.apagarse();
    }

}
