package actuadores;

import java.util.List;

public class SensorMovimiento implements SensorMovimientoFabricante {
	List<ReglaParaMovimiento> reglas;
	
	public SensorMovimiento(List<ReglaParaMovimiento> reglas) {
		this.reglas = reglas;
	}

	@Override
	public void seMovio() {
		reglas.forEach(ReglaParaMovimiento::huboMovimiento);
	}

	
}
