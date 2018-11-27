package actuadores.condicionesAbstractas;

import actuadores.Condicion;

import javax.persistence.Entity;

@Entity
public abstract class CondicionBool extends Condicion<Boolean>{

	@Override
	public abstract boolean seCumple(Boolean medicion);

}
