package actuadores;

import dominio.dispositivos.AireAcondicionadoInteligente;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "BT")
public class ActuadorBajaTemperaturaAC extends Actuador<AireAcondicionadoInteligente> {
    private Integer gradosQueBaja;

    public ActuadorBajaTemperaturaAC(Integer gradosQueBaja) {
        this.gradosQueBaja = gradosQueBaja;
    }

    public ActuadorBajaTemperaturaAC() {
    }

    @Override
    public void actuaSobre(AireAcondicionadoInteligente unAire) {
        unAire.bajarTemperatura(this.gradosQueBaja);
    }

}