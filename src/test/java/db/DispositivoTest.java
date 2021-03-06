package db;

import dominio.dispositivos.DispositivoInteligente;
import dominio.dispositivos.FabricaDeDispositivos;
import dominio.dispositivos.Periodo;
import org.junit.Assert;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;
import repositorios.RepoDispositivosInteligentes;

import java.time.LocalDateTime;

public class DispositivoTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

    private DispositivoInteligente dispositivoInteligente;
    private LocalDateTime fecha1;
    private LocalDateTime fecha2;
    private LocalDateTime fecha3;
    private LocalDateTime fecha4;
    private LocalDateTime fecha5;
    private LocalDateTime fecha6;

    public void setup() {
        super.setup();
        fecha1 = LocalDateTime.of(2018, 9, 1, 0, 0);
        fecha2 = LocalDateTime.of(2018, 9, 1, 12, 0);
        fecha3 = LocalDateTime.of(2018, 9, 2, 0, 0);
        fecha4 = LocalDateTime.of(2018, 9, 2, 12, 0);
        fecha5 = LocalDateTime.of(2018, 9, 3, 0, 0);
        fecha6 = LocalDateTime.of(2018, 9, 3, 12, 0);
        dispositivoInteligente = FabricaDeDispositivos.crearLED40("Led40", null, 1L);
        dispositivoInteligente.agregarPeriodo(new Periodo(fecha1,fecha2));
        dispositivoInteligente.agregarPeriodo(new Periodo(fecha3,fecha4));
        dispositivoInteligente.agregarPeriodo(new Periodo(fecha5,fecha6));
        RepoDispositivosInteligentes.instancia.agregarDispositivoInteligente(dispositivoInteligente);
    }

    @Test
    public void mostrarIntervalos() {
        DispositivoInteligente di = RepoDispositivosInteligentes.instancia.buscarPorId(dispositivoInteligente.getId());
        di.getPeriodosEncendido().forEach(p -> System.out.println(p));

    }

    @Test
    public void modificarYRecuperarNombre() {

        String nombreNuevo = "MyBigLedTV";
        dispositivoInteligente.setNombre(nombreNuevo);

        Assert.assertEquals(nombreNuevo, RepoDispositivosInteligentes.instancia.buscarPorId(dispositivoInteligente.getId()).getNombre());
    }

}
