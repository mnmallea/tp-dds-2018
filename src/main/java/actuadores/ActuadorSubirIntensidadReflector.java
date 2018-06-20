package actuadores;

import dominio.DispositivoInteligente;
import dominio.ReflectorInteligente;

public class ActuadorSubirIntensidadReflector implements Actuador{
	private Double luxQueSube;
	
	public ActuadorSubirIntensidadReflector(Double luxQueSube) {
		this.luxQueSube = luxQueSube;
	}

	
	@Override
	public void actuaSobre(DispositivoInteligente unDispositivo) {
		ReflectorInteligente reflector = (ReflectorInteligente) unDispositivo;
		reflector.aumentarIntensidad(luxQueSube);

	}

}
