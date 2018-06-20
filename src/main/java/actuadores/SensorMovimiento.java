package actuadores;

import java.util.List;

public class SensorMovimiento implements SensorMovimientoFabricante {
	List<ReglaParaMovimiento> reglas;
	
	@Override
	public Double seMovio() {
		reglas.forEach(regla -> regla.huboMovimiento());
		return null;
	}

	
}
