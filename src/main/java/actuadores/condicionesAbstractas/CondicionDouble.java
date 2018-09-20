package actuadores.condicionesAbstractas;

import javax.persistence.Entity;

import actuadores.Condicion;

@Entity
public abstract class CondicionDouble extends Condicion<Double>{

	@Override
	public abstract boolean seCumple(Double medicion);
	
}
