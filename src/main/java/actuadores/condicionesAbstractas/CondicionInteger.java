package actuadores.condicionesAbstractas;

import actuadores.Condicion;

import javax.persistence.Entity;

@Entity
public abstract class CondicionInteger extends Condicion<Integer>{

	@Override
	public abstract boolean seCumple(Integer medicion);	

}
