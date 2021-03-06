import dominio.Administrador;
import dominio.Transformador;
import dominio.Usuario;
import dominio.Zona;
import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import puntos.Point;
import repositorios.RepoTransformadores;
import repositorios.RepoUsuarios;
import repositorios.RepoZonas;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Bootstrap implements WithGlobalEntityManager, TransactionalOps, EntityManagerOps {

    public static void main(String[] args) {
        new Bootstrap().init();
        System.exit(0);
    }

    public void init() {
        List<Transformador> transformadores = Arrays.asList(new Transformador(new Point(10, 20)), new Transformador(new Point(-10, 40)), new Transformador(new Point(100, 121.5)));
        withTransaction(() -> {
            RepoTransformadores.instancia.agregarTransformadores(transformadores);
            Zona zona = new Zona(new Point(0, 0), 25., "Almagro");
            Zona otraZona = new Zona(new Point(80, 80), 47.0, "Villa Urquiza");
            RepoZonas.instance.guardarZona(zona);
            RepoZonas.instance.guardarZona(otraZona);
            Usuario cliente = new PersistidorClientesPrueba().cliente4;
            cliente.setUsername("belen");
            cliente.setHashedPassword("1234");
            RepoUsuarios.instancia.guardar(cliente);

            Usuario administrador = new Administrador("Martín", "Mallea", LocalDate.now(), 1234);
            administrador.setHashedPassword("zira");
            administrador.setUsername("tincho");
            RepoUsuarios.instancia.guardar(administrador);
        });
    }
}
