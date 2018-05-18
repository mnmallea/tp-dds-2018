package actuadores;

import dominio.Dispositivo;

public class Apagarse implements Accion{

	@Override
	public void aplicarseA(Dispositivo unDispositivo) {
		unDispositivo.apagarse();
	}
	

}
