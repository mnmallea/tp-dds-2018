import dominio.Categorizador;
import dominio.Cliente;
import dominio.Direccion;
import dominio.TipoDocumento;
import dominio.dispositivos.DispositivoInteligente;
import dominio.dispositivos.FabricaDeDispositivos;
import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import puntos.Point;
import repositorios.RepoClientes;
import simplex.EfectoSimplex;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PersistidorClientesPrueba implements WithGlobalEntityManager, TransactionalOps, EntityManagerOps {
    private Direccion unaDireccion = new Direccion(new Point(1.0, 1.0), "unaDireccion");
    private Direccion otraDireccion = new Direccion(new Point(10.0, 10.0), "otraDireccion");


    Cliente cliente = new Cliente("Eric", "Fahnle", TipoDocumento.DNI, 123, 123, unaDireccion,
            Categorizador.instancia.getR1(), new ArrayList<>(), new ArrayList<>(), LocalDate.now(), EfectoSimplex.NO_HACER_NADA);

    Cliente cliente2 = new Cliente("Gastón", "Prieto", TipoDocumento.DNI, 123, 123, otraDireccion,
            Categorizador.instancia.getR1(), new ArrayList<>(), new ArrayList<>(), LocalDate.now(), EfectoSimplex.NO_HACER_NADA);
    Cliente cliente3 = new Cliente("Martín", "Mallea", TipoDocumento.DNI, 123, 123, unaDireccion,
            Categorizador.instancia.getR1(), new ArrayList<>(), new ArrayList<>(), LocalDate.now(), EfectoSimplex.NO_HACER_NADA);

    Cliente cliente4 = new Cliente("Belén", "Trípodi", TipoDocumento.DNI, 123, 123, otraDireccion,
            Categorizador.instancia.getR1(), new ArrayList<>(Collections.singletonList(FabricaDeDispositivos.crearAire2200("Aire2200", null, 123L))),
            new ArrayList<>(), LocalDate.now(), EfectoSimplex.NO_HACER_NADA);

    Cliente cliente5 = new Cliente("Franco", "Curi", TipoDocumento.DNI, 123, 123, unaDireccion,
            Categorizador.instancia.getR1(), new ArrayList<>(), new ArrayList<>(), LocalDate.now(), EfectoSimplex.NO_HACER_NADA);

    Cliente cliente6 = new Cliente("Franco", "Bulgarelli", TipoDocumento.DNI, 123, 123, otraDireccion,
            Categorizador.instancia.getR1(), new ArrayList<>(), new ArrayList<>(), LocalDate.now(), EfectoSimplex.NO_HACER_NADA);

    Cliente cliente7 = new Cliente("Albert", "Einstein", TipoDocumento.DNI, 123, 123, unaDireccion,
            Categorizador.instancia.getR1(), new ArrayList<>(), new ArrayList<>(), LocalDate.now(), EfectoSimplex.NO_HACER_NADA);

    Cliente cliente8 = new Cliente("Teodoro", "Apellido", TipoDocumento.DNI, 123, 123, otraDireccion,
            Categorizador.instancia.getR1(), new ArrayList<>(), new ArrayList<>(), LocalDate.now(), EfectoSimplex.NO_HACER_NADA);

    Cliente cliente9 = new Cliente("Bill", "Gates", TipoDocumento.DNI, 123, 123, unaDireccion,
            Categorizador.instancia.getR1(), new ArrayList<>(), new ArrayList<>(), LocalDate.now(), EfectoSimplex.NO_HACER_NADA);

    Cliente cliente10 = new Cliente("Conejito", "Conejero", TipoDocumento.DNI, 123, 123, otraDireccion,
            Categorizador.instancia.getR1(), new ArrayList<>(), new ArrayList<>(), LocalDate.now(), EfectoSimplex.NO_HACER_NADA);
    Cliente cliente11 = new Cliente("sir", "lancelot", TipoDocumento.DNI, 123, 123, unaDireccion,
            Categorizador.instancia.getR1(), new ArrayList<>(), new ArrayList<>(), LocalDate.now(), EfectoSimplex.NO_HACER_NADA);

    Cliente cliente12 = new Cliente("Sherlock", "Holmes", TipoDocumento.DNI, 123, 123, otraDireccion,
            Categorizador.instancia.getR1(), new ArrayList<>(), new ArrayList<>(), LocalDate.now(), EfectoSimplex.NO_HACER_NADA);
    Cliente cliente13 = new Cliente("Hermione", "Perez", TipoDocumento.DNI, 123, 123, unaDireccion,
            Categorizador.instancia.getR1(), new ArrayList<>(), new ArrayList<>(), LocalDate.now(), EfectoSimplex.NO_HACER_NADA);

    Cliente cliente14 = new Cliente("Rosa", "Rosa", TipoDocumento.DNI, 123, 123, otraDireccion,
            Categorizador.instancia.getR1(), new ArrayList<>(), new ArrayList<>(), LocalDate.now(), EfectoSimplex.NO_HACER_NADA);

    Cliente cliente15 = new Cliente("Roberto", "Carlos", TipoDocumento.DNI, 123, 123, unaDireccion,
            Categorizador.instancia.getR1(), new ArrayList<>(), new ArrayList<>(), LocalDate.now(), EfectoSimplex.NO_HACER_NADA);

    Cliente cliente16 = new Cliente("Cristiano", "Ronaldo", TipoDocumento.DNI, 123, 123, otraDireccion,
            Categorizador.instancia.getR1(), new ArrayList<>(), new ArrayList<>(), LocalDate.now(), EfectoSimplex.NO_HACER_NADA);


    public List<Cliente> clientes() {
        return Arrays.asList(cliente, cliente2, cliente3, cliente4, cliente5, cliente6, cliente7, cliente8,
                cliente9, cliente10, cliente11, cliente12, cliente13, cliente14, cliente15, cliente16);
    }

    public void persistirClientes(){
        withTransaction(() ->{
            RepoClientes.instancia.agregarClientes(clientes());
        });
    }

    public static void main(String[] args) {
        new PersistidorClientesPrueba().persistirClientes();
        System.exit(0);
    }

}
