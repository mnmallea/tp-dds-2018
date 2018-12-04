import dominio.Categorizador;
import dominio.Cliente;
import dominio.Direccion;
import dominio.TipoDocumento;
import dominio.dispositivos.FabricaDeDispositivos;
import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import puntos.Point;
import repositorios.RepoUsuarios;
import simplex.EfectoSimplex;

import java.time.LocalDate;
import java.util.ArrayList;

public class PersistidorDispositivosPrueba implements WithGlobalEntityManager, TransactionalOps, EntityManagerOps {
    public static void main(String[] args) {
        new PersistidorDispositivosPrueba().init();
        System.exit(0);
    }

    public void init(){
        withTransaction(() -> {
            Cliente cliente = new Cliente("Julian", "Ezequiel", TipoDocumento.DNI, 123, 123, new Direccion(new Point(1,1), "Fake Street 123"),
                    Categorizador.instancia.getR1(), new ArrayList<>(), new ArrayList<>(), LocalDate.now(), EfectoSimplex.NO_HACER_NADA);
            cliente.setUsername("JulianEzequiel");
            cliente.setHashedPassword("hola123");
            cliente.registrarDispositivoInteligente(FabricaDeDispositivos.crearAire2200("Aire fresco", null, 3L));
            cliente.registrarDispositivoInteligente(FabricaDeDispositivos.crearLED32("Tele", null, 4L));
            RepoUsuarios.instancia.guardar(cliente);
        });
    }
}
