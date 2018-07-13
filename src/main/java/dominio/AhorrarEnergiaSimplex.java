package dominio;

public class AhorrarEnergiaSimplex implements EfectoSimplex {

	@Override
	public void aplicarseA(Dispositivo dispositivo) {
		dispositivo.ahorrarEnergia();
	}

}
