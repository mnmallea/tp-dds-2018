package repositorios;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import dominio.TipoUsuario;
import dominio.Usuario;

public class RepoUsuarios implements WithGlobalEntityManager, EntityManagerOps {
	public static final RepoUsuarios instancia = new RepoUsuarios();

	private RepoUsuarios() {
	}

	public List<Usuario> getUsuarios() {
		return entityManager().createQuery("from Usuario").getResultList();
	}

		
	public TipoUsuario tipoDeUsuario(Long user) {
		//TODO fijarnos que no esto no reviente por null pointer exception
		System.out.println(entityManager().find(Usuario.class, user));
		return entityManager().find(Usuario.class, user).getTipoUsuario();
	}

	public void guardar(Usuario usuario) {
		
		entityManager().persist(usuario);
		System.out.println("HOLIS");
		
	}
}
