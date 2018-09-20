package actuadores.condicionesAbstractas;

import javax.persistence.Entity;

import actuadores.Condicion;

@Entity
public abstract class CondicionBool extends Condicion<Boolean>{

	@Override
	public abstract boolean seCumple(Boolean medicion);

}
