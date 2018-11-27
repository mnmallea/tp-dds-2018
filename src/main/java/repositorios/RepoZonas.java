package repositorios;

import dominio.Zona;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import java.util.List;

public class RepoZonas implements WithGlobalEntityManager {

    public static RepoZonas instance = new RepoZonas();

    private RepoZonas() {

    }

    public Zona getZonaPorID(Long idZona) {
        return entityManager().find(Zona.class, idZona);
    }

	public List<Zona> getZonas(){
        return entityManager().createQuery("from Zona", Zona.class).getResultList();
    }

    public void guardarZona(Zona zona){
        entityManager().persist(zona);
    }

}
