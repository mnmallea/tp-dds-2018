package repositorios;

import dominio.Usuario;
import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RepoUsuarios implements WithGlobalEntityManager, EntityManagerOps {
    public static final RepoUsuarios instancia = new RepoUsuarios();

    private RepoUsuarios() {
    }

    public List<Usuario> getUsuarios() {
        return entityManager().createQuery("from Usuarios").getResultList();
    }

    public Usuario findUsuarioByUsername(String username){
        CriteriaBuilder cb = entityManager().getCriteriaBuilder();
        CriteriaQuery<Usuario> cr = cb.createQuery(Usuario.class);
        Root<Usuario> root = cr.from(Usuario.class);
        TypedQuery<Usuario> query = entityManager()
                .createQuery(cr.select(root).where(cb.equal(root.get("username"), username)));
        Usuario result = null;
        try {
            result = query.getSingleResult();
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }


    public void guardar(Usuario usuario) {
        entityManager().persist(usuario);
    }
}
