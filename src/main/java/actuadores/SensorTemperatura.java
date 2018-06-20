package actuadores;

import java.util.List;

public class SensorTemperatura implements SensorTemperaturaFabricante{
	List<ReglaParaTemperatura> reglas;
	
	@Override
	public void laTemperaturaCambioA(Double temperatura) {
		reglas.forEach(regla-> regla.temperaturaCambioA(temperatura));
	}

}
