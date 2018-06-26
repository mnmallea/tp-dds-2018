package actuadores;

import dominio.DispositivoInteligente;

public class ActuadorEncenderDispositivo<T extends  DispositivoInteligente> implements Actuador{

	@Override
	public void actuaSobre(DispositivoInteligente unDispositivo) {
		unDispositivo.encenderse();
	}
}
