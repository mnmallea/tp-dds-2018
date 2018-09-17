package db;

import dominio.dispositivos.DispositivoInteligente;
import dominio.dispositivos.FabricaDeDispositivos;
import dominio.dispositivos.PeriodoEncendido;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDateTime;

public class DispositivoTest {

    private EntityManager em;
    private EntityTransaction entityTransaction;
    private DispositivoInteligente dispositivoInteligente;
    private LocalDateTime fecha1;
    private LocalDateTime fecha2;
    private LocalDateTime fecha3;
    private LocalDateTime fecha4;
    private LocalDateTime fecha5;
    private LocalDateTime fecha6;

    @Before
    public void before() {
        fecha1 = LocalDateTime.of(2018, 9, 1, 0, 0);
        fecha2 = LocalDateTime.of(2018, 9, 1, 12, 0);
        fecha3 = LocalDateTime.of(2018, 9, 2, 0, 0);
        fecha4 = LocalDateTime.of(2018, 9, 2, 12, 0);
        fecha5 = LocalDateTime.of(2018, 9, 3, 0, 0);
        fecha6 = LocalDateTime.of(2018, 9, 3, 12, 0);
        em = PerThreadEntityManagers.getEntityManager();
        entityTransaction = em.getTransaction();
        entityTransaction.begin();
        dispositivoInteligente = FabricaDeDispositivos.crearLED40("Led40", null, 1L);
        dispositivoInteligente.agregarPeriodo(new PeriodoEncendido(fecha1,fecha2));
        dispositivoInteligente.agregarPeriodo(new PeriodoEncendido(fecha3,fecha4));
        dispositivoInteligente.agregarPeriodo(new PeriodoEncendido(fecha5,fecha6));

        em.persist(dispositivoInteligente);
    }

    @After
    public void after() {
        entityTransaction.rollback();
        em.clear();
    }

    @Test
    public void mostrarIntervalos() {
        DispositivoInteligente di = em.find(DispositivoInteligente.class, 1L);
        di.getPeriodosEncendido().forEach(p -> System.out.println(p.toString()));

    }

    @Test
    public void modificarYRecuperarNombre() {

        String nombreNuevo = "MyBigLedTV";
        dispositivoInteligente.setNombre(nombreNuevo);

        Assert.assertEquals(nombreNuevo, em.find(DispositivoInteligente.class, 1L).getNombre());
    }

}
