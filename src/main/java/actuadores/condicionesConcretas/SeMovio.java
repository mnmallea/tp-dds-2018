package actuadores.condicionesConcretas;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import actuadores.condicionesAbstractas.CondicionBool;

@Entity
@DiscriminatorValue(value = "SeMovio")
public class SeMovio extends CondicionBool{
	private Boolean valorBool;
	
	
	
	public SeMovio(Boolean huboMovimiento) {
		this.valorBool= huboMovimiento;
	}

	public SeMovio() {
	}
	
	@Override
	public boolean seCumple(Boolean medicion) {
		return valorBool;
	}
}
