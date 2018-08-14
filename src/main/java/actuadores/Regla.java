package actuadores;

import dominio.dispositivos.DispositivoInteligente;

import java.util.List;

public class Regla<T,D extends DispositivoInteligente<?>> {
	private Condicion<T> condicion;
	private List<Actuador<D>> actuadores;
	private D dispositivo;

	public Regla(Condicion<T> condicion, List<Actuador<D>> actuadores, D dispositivo) {
		this.condicion = condicion;
		this.actuadores = actuadores;
		this.dispositivo = dispositivo;
	}

	public void seTomoMedicion(T medicion) {
		if(condicion.seCumple(medicion)){
			actuadores.forEach(actuador -> actuador.actuaSobre(dispositivo));
		}
	}
}
