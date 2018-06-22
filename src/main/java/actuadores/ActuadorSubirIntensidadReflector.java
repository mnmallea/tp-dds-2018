package actuadores;

import dominio.ReflectorInteligente;

public class ActuadorSubirIntensidadReflector implements Actuador<ReflectorInteligente>{
	private Double luxQueSube;
	
	public ActuadorSubirIntensidadReflector(Double luxQueSube) {
		this.luxQueSube = luxQueSube;
	}

	
	@Override
	public void actuaSobre(ReflectorInteligente unReflector) {
		unReflector.aumentarIntensidad(luxQueSube);
	}

}
