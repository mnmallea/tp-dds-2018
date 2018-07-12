package dominio;

import puntos.Point;
import repositorios.RepoClientes;

import java.util.List;

public class Transformador {
	private Point coordenadas;

	public Transformador(Point coordenadas) {
		this.coordenadas = coordenadas;
	}

	public Double energiaSuministrada() {
		return getClientes().stream().mapToDouble(Cliente::consumo).sum();
	}

	private List<Cliente> getClientes() {
		return RepoClientes.instancia.clientesDeTransformador(this);
	}

	public Point getCoordenadas() {
		return coordenadas;
	}
}

