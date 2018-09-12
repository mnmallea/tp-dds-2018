package actuadores;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import dominio.dispositivos.DispositivoInteligente;

@SuppressWarnings("rawtypes")
@Entity
@DiscriminatorValue(value = "RM")
public class ReglaParaMovimiento extends Regla<Boolean,DispositivoInteligente> implements ReglaParaMovimientoFabricante {

    public ReglaParaMovimiento() {
    }

	@Override
	public void huboMovimiento() {
		this.seTomoMedicion(true);
	}
}
