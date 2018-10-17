package repositorios;

import dominio.Zona;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public class RepoZonas implements WithGlobalEntityManager {

	public static RepoZonas instance = new RepoZonas();
	
	private RepoZonas() {
		
	}

	public Zona getZonaPorID(Long idZona) {
		return entityManager().find(Zona.class, idZona);
	}

}
