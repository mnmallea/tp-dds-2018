package actuadores;

import dominio.dispositivos.DispositivoInteligente;

public class ActuadorEncenderDispositivo<T extends  DispositivoInteligente> implements Actuador{

	@Override
	public void actuaSobre(DispositivoInteligente unDispositivo) {
		unDispositivo.encenderse();
	}
}
