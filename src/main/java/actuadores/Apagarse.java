package actuadores;

import dominio.DispositivoInteligente;

public class Apagarse implements Accion{

	@Override
	public void aplicarseA(DispositivoInteligente unDispositivo) {
		unDispositivo.apagarse();
	}
	

}
