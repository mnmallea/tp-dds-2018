package dominio;

import org.uqbar.geodds.Point;

import java.util.List;

public class Zona {

	private List<Transformador> transformadores;
	private Double radio;
	private Point centro;

	public Zona(Double radio, Point centro) {
		this.radio = radio;
		this.centro = centro;
	}

	public List<Transformador> getTransformadores() {
		return transformadores;
	}

	public void agregarTransformador(Transformador unTransformador) {
		if (!this.estaDentroDeZona(unTransformador.getCoordenadas()))
			throw new RuntimeException("El transformador no está dentro de esta zona");
		transformadores.add(unTransformador);
	}

	public Double consumoTotal() {
		return transformadores.stream().mapToDouble(Transformador::energiaSuministrada).sum();
	}

	private boolean estaDentroDeZona(Point unPunto) {
		return unPunto.distance(this.centro) <= radio;
	}

}
