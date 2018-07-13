package dominio;

public class AhorrarEnergia implements EfectoSimplex {

	@Override
	public void aplicarseA(Dispositivo dispositivo) {
		dispositivo.ahorrarEnergia();
	}

}
