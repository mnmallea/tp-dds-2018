package repositorios;

import dominio.Transformador;
import dominio.Zona;
import puntos.Point;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Mapa {
	private List<Zona> zonas;

	public static final Mapa instancia = new Mapa();

	private Mapa(){
		zonas = new ArrayList<>();
	}

	public void agregarZona(Zona unaZona){
		zonas.add(unaZona);
	}

	public void limpiarZonas(){
		zonas = new ArrayList<>();
	}

	public Transformador transformadorMasCercanoA(Point coordenada) {
		return this.transformadores().stream().min(Comparator.comparingDouble(transformador -> coordenada.distance(transformador.getCoordenadas()))).get();
	}

	private List<Transformador> transformadores(){
		return zonas.stream().flatMap(zona -> zona.getTransformadores().stream()).collect(Collectors.toList());
	}
}
