import dominio.Categorizador;
import dominio.Cliente;
import dominio.Direccion;
import dominio.TipoDocumento;
import dominio.dispositivos.DispositivoInteligente;
import dominio.dispositivos.FabricaDeDispositivos;
import dominio.dispositivos.Periodo;
import dominio.dispositivos.fabricantes.Fabricante;
import dominio.dispositivos.fabricantes.UnFabricante;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import puntos.Point;
import repositorios.RepoClientes;
import simplex.EfectoSimplex;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PruebaUsuarioSimplexable implements TransactionalOps, WithGlobalEntityManager {

    public static void main(String[] args) {
        Fabricante fabricante = new UnFabricante();
        DispositivoInteligente dispositivo = FabricaDeDispositivos.crearLED32("Mi LED", fabricante, 3L);
        dispositivo.agregarPeriodo(new Periodo(LocalDateTime.now().minusMonths(1), LocalDateTime.now()));
        dispositivo.encenderse();
        List<DispositivoInteligente> dispositivoInteligentes = new ArrayList<>(Collections.singletonList(dispositivo));


        Cliente cliente = new Cliente("Mister", "Simplex", TipoDocumento.DNI, 123, 123, new Direccion(new Point(48564, 4894), "Medrano 951"),
                Categorizador.instancia.getR1(), dispositivoInteligentes, new ArrayList<>(), LocalDate.now(), EfectoSimplex.APAGAR);
        new PruebaUsuarioSimplexable().withTransaction(() -> {
            RepoClientes.instancia.guardarCliente(cliente);
        });
        System.exit(0);
    }
}
