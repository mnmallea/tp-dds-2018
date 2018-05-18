package actuadores;

import java.util.List;
import java.util.stream.Collectors;

public class Regla {
	private List<Medicion> mediciones;
	private List<Sensor> sensores;


	public Regla(List<Sensor> sensores) {
		this.sensores = sensores;
	}

	
	public void dispararAcciones() {
		mediciones.forEach(medicion-> medicion.dispararAccion());
	}

	public void setMediciones(){
		mediciones = sensores.stream().map(sensor -> sensor.tomarMedicion()).collect(Collectors.toList());
	}
	
}