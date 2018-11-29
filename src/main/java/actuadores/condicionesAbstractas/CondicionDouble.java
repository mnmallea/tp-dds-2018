package actuadores.condicionesAbstractas;

import actuadores.Condicion;

import javax.persistence.Entity;

@Entity
public abstract class CondicionDouble extends Condicion<Double>{

	@Override
	public abstract boolean seCumple(Double medicion);
	
}
