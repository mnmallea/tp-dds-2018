package repositorios;

import dominio.Transformador;
import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class RepoTransformadores implements WithGlobalEntityManager, EntityManagerOps {
    public static final RepoTransformadores instancia = new RepoTransformadores();

    private RepoTransformadores() {
    }

    @SuppressWarnings("unchecked")
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

    public Transformador buscarPorID(Long id) {
        return entityManager().find(Transformador.class, id);
    }

    public List<Transformador> getPaginaTransformadores(int pageNumber, int pageSize) {
        TypedQuery<Transformador> query = entityManager().createQuery("from Transformador t order by t.id", Transformador.class);
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }


    public List<Transformador> getPaginaTransformadoresDeZona(int pageNumber, int pageSize, Long idZona) {
        TypedQuery<Transformador> query= entityManager().createQuery("from Transformador t where t.zona_id = :id order by t.id", Transformador.class)
                .setParameter("id", idZona);
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    public Long cantidadDeTransformadores() {
        Query queryTotal = entityManager().createQuery("Select count(t.id) from Transformador t");
        return (long) queryTotal.getSingleResult();
    }

    public Integer cantidadDePaginas(Integer pageSize) {
        return (int) Math.ceil(((double) cantidadDeTransformadores()) / pageSize);
    }

}