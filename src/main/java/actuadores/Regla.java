package actuadores;

import java.util.List;

public class Regla {
	private List<Medicion> mediciones;
	
	public void dispararAcciones() {
		mediciones.forEach(unaMedicion -> unaMedicion.desencadenarAccionSiDebe());
	}
}
