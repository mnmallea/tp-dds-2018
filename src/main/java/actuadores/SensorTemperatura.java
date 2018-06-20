package actuadores;

import java.util.List;

public class SensorTemperatura implements SensorTemperaturaFabricante {
	List<ReglaParaTemperatura> reglas;

	public SensorTemperatura(List<ReglaParaTemperatura> reglas) {
		this.reglas = reglas;
	}

	@Override
	public void laTemperaturaCambioA(Double temperatura) {
		reglas.forEach(regla -> regla.temperaturaCambioA(temperatura));
	}

}
