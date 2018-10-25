import dominio.Cliente;
import dominio.dispositivos.FabricaDeDispositivos;
import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import repositorios.RepoUsuarios;

public class PersistidorDispositivosPiolas implements WithGlobalEntityManager, TransactionalOps, EntityManagerOps {
    public static void main(String[] args) {
        new PersistidorDispositivosPiolas().init();
    }

    public void init(){
        withTransaction(() -> {
            Cliente cliente = new PersistidorClientesPrueba().cliente2;
            cliente.setUsername("JulianEzequiel");
            cliente.setHashedPassword("hola123");
            cliente.registrarDispositivoInteligente(FabricaDeDispositivos.crearAire2200("Aire fresco", null, 3L));
            cliente.registrarDispositivoInteligente(FabricaDeDispositivos.crearLED32("Tele", null, 4L));
            RepoUsuarios.instancia.guardar(cliente);
        });
    }
}
