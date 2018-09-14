package db;

import dominio.*;
import dominio.dispositivos.DispositivoInteligente;
import dominio.dispositivos.FabricaDeDispositivos;
import dominio.dispositivos.PeriodoEncendido;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import puntos.Point;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConsumoTest {


    public static final long ID_TRANSFORMADOR1 = 1L;
    private EntityManager em;
    private EntityTransaction entityTransaction;
    private Zona zona1;
    private Cliente cliente;
    private LocalDateTime fecha1;
    private LocalDateTime fecha2;
    private LocalDateTime fecha3;
    private LocalDateTime fecha4;
    private DispositivoInteligente unDispositivoInteligente;
    private DispositivoInteligente otroDispositivoInteligente;
    private PeriodoEncendido periodoA;
    private PeriodoEncendido periodoB;
    private Transformador transformador1;


    @Before
    public void before() {
        em = PerThreadEntityManagers.getEntityManager();
        entityTransaction = em.getTransaction();
        entityTransaction.begin();

        zona1 = new Zona(45.0, new Point(0.0, 0.0));
        zona1.setId(1L);

        unDispositivoInteligente = (DispositivoInteligente) FabricaDeDispositivos.
                crearLED40("LED", null, 1L);
        otroDispositivoInteligente = (DispositivoInteligente) FabricaDeDispositivos.
                crearAire2200("AIRE", null, 2L);

        fecha1 = LocalDateTime.of(2018, 9, 1, 0, 0);
        fecha2 = LocalDateTime.of(2018, 9, 1, 12, 0);
        fecha3 = LocalDateTime.of(2018, 9, 2, 0, 0);
        fecha4 = LocalDateTime.of(2018, 9, 2, 14, 0);

        periodoA = new PeriodoEncendido(fecha1, fecha2);
        periodoB = new PeriodoEncendido(fecha3, fecha4);

        unDispositivoInteligente.agregarPeriodo(periodoA);
        unDispositivoInteligente.agregarPeriodo(periodoB);
        otroDispositivoInteligente.agregarPeriodo(periodoA);

        List<DispositivoInteligente> listaDispositivosInteligentes = new ArrayList<DispositivoInteligente>();
        listaDispositivosInteligentes.add(unDispositivoInteligente);
        listaDispositivosInteligentes.add(otroDispositivoInteligente);


        cliente = new Cliente("Julian Ezequiel", "Pico", TipoDocumento.DNI, 401, 456,
                new Direccion(new Point(2.0, 3.0), "Calle 5"), Categorizador.instancia.getR1(),
                listaDispositivosInteligentes, new ArrayList<>(),
                LocalDate.now(), zona1);

        transformador1 = new Transformador(new Point(0.00, 9.00));
        transformador1.setId(ID_TRANSFORMADOR1);
        transformador1.agregarCliente(cliente);

        cliente.setId(1L);
        em.persist(zona1);
        em.persist(cliente);
        em.persist(transformador1);

    }

    @After
    public void after() {
        entityTransaction.rollback();
    }

    @Test
    public void mostrarConsumoTotalCliente() {

        System.out.println("Consumo total del cliente: " + cliente.consumoDeDispositivosInteligentesEnPeriodo(periodoA).toString());
    }

    @Test
    public void mostrarConsumoTotalDispositivo() {
        double consumoPromedio = unDispositivoInteligente.consumoTotal() / unDispositivoInteligente.getPeriodosEncendido().size();
        System.out.println("Consumo promedio del dispositivo " + unDispositivoInteligente.getNombre()
                + ": " + consumoPromedio);
    }

    @Test
    public void consumoTotalTransformadores() {
        System.out.println("Consumo promedio para el transformador: " + transformador1.consumoTotal(periodoA) / transformador1.getClientes().size());
    }

    @Test
    public void recuperarDispositivoAsociado() {
        Transformador transformadorRecuperado = em.find(Transformador.class, ID_TRANSFORMADOR1);
        Cliente unCliente = transformadorRecuperado.getClientes().get(0);
        DispositivoInteligente dispositivoInteligente = unCliente.getDispositivosInteligentes().get(0);

        Double consumoInicial = dispositivoInteligente.consumoTotal();
        dispositivoInteligente.agregarPeriodo(new PeriodoEncendido(LocalDateTime.of(2018, 9, 2, 23, 0),
        LocalDateTime.of(2018, 9, 4, 14, 0)));

        Assert.assertTrue(consumoInicial < dispositivoInteligente.consumoTotal());
    }

}
