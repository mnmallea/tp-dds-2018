package repositorios;

import actuadores.Regla;
import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public class RepoReglas implements WithGlobalEntityManager, EntityManagerOps {
    public static final RepoReglas instancia = new RepoReglas();


    public void agregarRegla(Regla regla) {
        entityManager().persist(regla);
    }

    public Regla buscarReglaPorId(Long id){
        return entityManager().find(Regla.class, id);
    }
}
