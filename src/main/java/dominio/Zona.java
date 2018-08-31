package dominio;

import puntos.Point;
import repositorios.RepoTransformadores;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Zona {

	private List<Transformador> transformadores;
	private List<Cliente> clientes;
	private Double radio;
	private Point centro;

	public Zona(Double radio, Point centro) {
		this.transformadores = this.inicializarTransformadores();
		this.radio = radio;
		this.centro = centro;
		this.clientes = this.inicializarClientes();
	}

	private List<Transformador> inicializarTransformadores() {
		List<Transformador> transformadores = AdministradorTransformadores.instancia.getTransformadores();
		return transformadores.stream().filter(transformador -> this.estaDentroDeZona(transformador.getCoordenadas())).collect(Collectors.toList());
	}

	private List<Cliente> inicializarClientes() {
		List<Cliente> clientes = AdministradorClientes.instancia.getClientes();
		return clientes.stream().filter(cliente-> cliente.getZona().equals(this)).collect(Collectors.toList());
	}

	public Transformador transformadorMasCercanoA(Point coordenada){
		return transformadores.stream().min(Comparator.comparingDouble(transformador -> coordenada.distance(transformador.getCoordenadas()))).get();
	}

	public void asignarClienteATransformador(Cliente cliente){

		Transformador transformador = this.transformadorMasCercanoA(cliente.getDireccion().getCoordenada());

		transformador.agregarCliente(cliente);
	}

	public void asignarATransformadores(){
		this.clientes.forEach(this::asignarClienteATransformador);
	}

	public Double consumoTotal() {
		List<Transformador> transformadores = this.inicializarTransformadores();
		return transformadores.stream().mapToDouble(Transformador::energiaSuministrada).sum();
	}

	private boolean estaDentroDeZona(Point unPunto) {
		return unPunto.distance(this.centro) <= radio;
	}

}
