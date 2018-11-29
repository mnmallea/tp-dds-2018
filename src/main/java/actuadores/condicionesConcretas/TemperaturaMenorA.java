package actuadores.condicionesConcretas;

import actuadores.condicionesAbstractas.CondicionDouble;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "TemperaturaMenorA")
public class TemperaturaMenorA extends CondicionDouble{
	private Double valorDouble;
	
	public TemperaturaMenorA(Double temperatura) {
		this.valorDouble= temperatura;
	}
	
	public TemperaturaMenorA() {
	}
	
	@Override
	public boolean seCumple(Double medicion) {
		return medicion < this.valorDouble; 
		
	}
}
