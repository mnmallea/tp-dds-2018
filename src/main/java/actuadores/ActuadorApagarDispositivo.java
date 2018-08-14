package actuadores;

import dominio.dispositivos.DispositivoInteligente;
import dominio.dispositivos.fabricantes.Fabricante;

public class ActuadorApagarDispositivo implements Actuador<DispositivoInteligente<? extends Fabricante>>{

	@Override
	public void actuaSobre(DispositivoInteligente unDispositivo) {
		unDispositivo.apagarse();
	}

}
