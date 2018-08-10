package dominio;

import puntos.Point;
import repositorios.RepoClientes;
import repositorios.RepoTransformadores;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Zona {

	private List<Transformador> transformadores;
	private List<Cliente> clientes;
	private Double radio;
	private Point centro;

	public Zona(Double radio, Point centro) {
		this.radio = radio;
		this.centro = centro;
		this.transformadores = new ArrayList<>();
	}

	public List<Transformador> getTransformadores() {
		List<Transformador> transformadores = RepoTransformadores.instancia.getTransformadores();
		return transformadores.stream().filter(transformador -> this.estaDentroDeZona(transformador.getCoordenadas())).collect(Collectors.toList());
	}

	public List<Cliente> getClientes() {
		List<Cliente> clientes = RepoClientes.instancia.getClientes();
		return clientes.stream().filter(cliente-> cliente.getZona().equals(this)).collect(Collectors.toList());
	}

	public Double consumoTotal() {
		return transformadores.stream().mapToDouble(Transformador::energiaSuministrada).sum();
	}

	private boolean estaDentroDeZona(Point unPunto) {
		return unPunto.distance(this.centro) <= radio;
	}

}
