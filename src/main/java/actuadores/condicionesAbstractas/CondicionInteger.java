package actuadores.condicionesAbstractas;

import javax.persistence.Entity;

import actuadores.Condicion;

@Entity
public abstract class CondicionInteger extends Condicion<Integer>{

	@Override
	public abstract boolean seCumple(Integer medicion);	

}
