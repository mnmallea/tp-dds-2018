package dominio;

public class ApagarSimplex implements EfectoSimplex {

	@Override
	public void aplicarseA(Dispositivo dispositivo) {
		dispositivo.apagarse();
	}

}
