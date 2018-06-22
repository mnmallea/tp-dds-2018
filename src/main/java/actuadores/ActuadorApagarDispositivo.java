package actuadores;

import dominio.DispositivoInteligente;

public class ActuadorApagarDispositivo implements Actuador<DispositivoInteligente>{

	@Override
	public void actuaSobre(DispositivoInteligente unDispositivo) {
		unDispositivo.apagarse();
	}

}
