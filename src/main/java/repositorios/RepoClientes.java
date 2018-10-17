package repositorios;

import dominio.Cliente;
import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import java.util.List;

public class RepoClientes implements WithGlobalEntityManager, EntityManagerOps {
    public static final RepoClientes instancia = new RepoClientes();

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
}
