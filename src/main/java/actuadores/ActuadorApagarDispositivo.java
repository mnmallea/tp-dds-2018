package actuadores;

import dominio.DispositivoInteligente;

public class ActuadorApagarDispositivo implements Actuador{

	@Override
	public void actuaSobre(DispositivoInteligente unDispositivo) {
		unDispositivo.apagarse();
	}

}
