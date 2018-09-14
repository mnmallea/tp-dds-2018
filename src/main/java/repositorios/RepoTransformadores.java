package repositorios;

import dominio.Transformador;
import dominio.Zona;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public class RepoTransformadores {
    public static final RepoTransformadores instancia = new RepoTransformadores();
    private List<Transformador> transformadores = new ArrayList<>();

    private RepoTransformadores() {
    }

    public List<Transformador> getTransformadores() {
        return transformadores;
    }

    public void setTransformadores(List<Transformador> transformadores) {
        this.transformadores = transformadores;
    }

    public void agregarTransformador(Transformador unTransformador) {
        transformadores.add(unTransformador);
    }

    public void limpiarTransformadores() {
        transformadores = new ArrayList<>();
    }

	public static void persistirSiDebe(Transformador t) {
		
		EntityManager em = PerThreadEntityManagers.getEntityManager();

		List<Transformador> transformadoresRecuperados = em.createQuery("select trans from Transformador trans").getResultList();
		
		if (!transformadoresRecuperados.stream().anyMatch(tr -> tr.getId().equals(t.getId())))
		{
			em.persist(t);
		}
	}


}