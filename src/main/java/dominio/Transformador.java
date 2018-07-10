package dominio;

import org.uqbar.geodds.Point;

public class Transformador {
	private Point coordenada;

	public double distanciaA(Cliente unCliente) {
		return coordenada.distance(unCliente.getDireccion().getCoordenada());
	}

	public Float energiaSuministrada() {
		return null; //todo
	}
}

