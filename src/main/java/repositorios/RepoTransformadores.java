package repositorios;

import dominio.Transformador;
import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import java.util.List;

public class RepoTransformadores implements WithGlobalEntityManager, EntityManagerOps {
    public static final RepoTransformadores instancia = new RepoTransformadores();

    private RepoTransformadores() {
    }

    public List<Transformador> getTransformadores() {
        return entityManager().createQuery("from Transformador").getResultList();
    }

    public void agregarTransformadores(List<Transformador> transformadores) {
        transformadores.forEach(this::agregarTransformador);
    }

    public void agregarTransformador(Transformador unTransformador) {
        entityManager().persist(unTransformador);
    }

    public void persistirSiDebe(List<Transformador> transformadores) {

        List<Transformador> transformadoresRecuperados = this.getTransformadores();
        transformadores.forEach(t -> {

                    if (transformadoresRecuperados.stream().noneMatch(tr -> tr.getIdEnre().equals(t.getIdEnre()))) {
                        entityManager().persist(t);
                    }
                }
        );
    }


}