package repositorios;

import dominio.Cliente;
import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@SuppressWarnings("unchecked")
public class RepoClientes implements WithGlobalEntityManager, EntityManagerOps {
    public static final RepoClientes instancia = new RepoClientes();

    private CriteriaBuilder criteriaBuilder;

    private RepoClientes() {
    }

    public List<Cliente> getClientes() {
        return entityManager().createQuery("from Cliente").getResultList();
    }

    public void agregarClientes(List<Cliente> clientes) {
        clientes.forEach(this::guardarCliente);
    }

    public void guardarCliente(Cliente cliente) {
        entityManager().persist(cliente);
    }

    public Cliente buscarClientePorId(Long id) {
        return entityManager().find(Cliente.class, id);
    }

    public List<Cliente> getPaginaClientes(int pageNumber, int pageSize) {
        Query clientesQuery = entityManager().createQuery("from Cliente c order by c.id");
        clientesQuery.setFirstResult((pageNumber - 1) * pageSize);
        clientesQuery.setMaxResults(pageSize);
        return clientesQuery.getResultList();
    }

    public Long cantidadDeClientes() {
        Query queryTotal = entityManager().createQuery("Select count(c.id) from Cliente c");
        long countResult = (long) queryTotal.getSingleResult();
        return countResult;
    }

    public Integer cantidadDePaginas(int pageSize) {
        return (int) Math.ceil(((double) cantidadDeClientes()) / pageSize);
    }
}
