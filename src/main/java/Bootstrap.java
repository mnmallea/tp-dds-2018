import dominio.TipoUsuario;
import dominio.Transformador;
import dominio.Usuario;
import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import puntos.Point;
import repositorios.RepoTransformadores;
import repositorios.RepoUsuarios;

import java.util.Arrays;
import java.util.List;

public class Bootstrap implements WithGlobalEntityManager, TransactionalOps, EntityManagerOps {

    public static void main(String[] args) {
        new Bootstrap();
    }

    public Bootstrap() {
        new Bootstrap().init();
    }

    public void init() {
        List<Transformador> transformadores = Arrays.asList(new Transformador(new Point(10, 20)), new Transformador(new Point(-10, 40)), new Transformador(new Point(100, 121.5)));
        withTransaction(() -> {
            RepoTransformadores.instancia.agregarTransformadores(transformadores);
            RepoUsuarios.instancia.guardar(new Usuario(1234L,"belen", TipoUsuario.ADMINISTRADOR ));

        });
    }
}
