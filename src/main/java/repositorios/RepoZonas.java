package repositorios;

import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import dominio.Zona;

public class RepoZonas {

	public static RepoZonas instance = new RepoZonas();
	
	private RepoZonas() {
		
	}

	public Zona getZonaPorID(Long idZona) {
		EntityManager em = PerThreadEntityManagers.getEntityManager();
		Zona zona = em.find(Zona.class, idZona);
		return zona;
	}

}
