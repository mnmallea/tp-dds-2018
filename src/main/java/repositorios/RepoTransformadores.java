package repositorios;

import dominio.Cliente;
import dominio.Transformador;

import java.util.ArrayList;
import java.util.Comparator;

public class RepoTransformadores {
	private ArrayList<Transformador> transformadores;
	public static RepoTransformadores instancia = new RepoTransformadores();

	private RepoTransformadores() {
		transformadores = new ArrayList<Transformador>();
	}

	public void agregarTransformador(Transformador unTransformador) {
		transformadores.add(unTransformador);
	}

	public Transformador transformadorMasCercanoA(Cliente unCliente){
		return transformadores.stream().min(Comparator.comparingDouble(transformador -> transformador.distanciaA(unCliente))).get();
	}


}
