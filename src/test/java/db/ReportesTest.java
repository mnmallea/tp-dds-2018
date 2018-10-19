package db;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import dominio.Categorizador;
import dominio.Cliente;
import dominio.Direccion;
import dominio.TipoDocumento;
import dominio.Transformador;
import dominio.Zona;
import dominio.dispositivos.DispositivoInteligente;
import dominio.dispositivos.FabricaDeDispositivos;
import dominio.dispositivos.PeriodoEncendido;
import puntos.Point;
import repositorios.AdministradorClientes;
import repositorios.AdministradorTransformadores;
import repositorios.RepoDispositivosInteligentes;
import repositorios.RepoTransformadores;

public class ReportesTest  extends AbstractPersistenceTest implements WithGlobalEntityManager {

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


    public void setup() {
        super.setup();

        zona1 = new Zona(45.0, new Point(0.0, 0.0));
        zona1.setId(1L);

        unDispositivoInteligente = FabricaDeDispositivos.
                crearLED40("LED", null, 1L);
        otroDispositivoInteligente = FabricaDeDispositivos.
                crearAire2200("AIRE", null, 2L);

        fecha1 = LocalDateTime.of(2018, 9, 1, 0, 0);
        fecha2 = LocalDateTime.of(2018, 9, 1, 12, 0);
        fecha3 = LocalDateTime.of(2018, 9, 2, 0, 0);
        fecha4 = LocalDateTime.of(2018, 9, 2, 14, 0);

        periodoA = new PeriodoEncendido(fecha1.plusHours(1), fecha2.minusHours(1));
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
                LocalDate.now());

        transformador1 = new Transformador(new Point(0.00, 9.00));
        
        RepoDispositivosInteligentes.instancia.agregarDispositivosInteligentes(listaDispositivosInteligentes);
        AdministradorClientes.instancia.agregarCliente(cliente);
        AdministradorTransformadores.instancia.agregarTransformador(transformador1);
        
        transformador1.setClientes(AdministradorClientes.instancia.inicializarClientes(transformador1));
    }


    @Test
    public void mostrarConsumoTotalCliente() {

        System.out.println("Consumo total del cliente: " + cliente.consumoDeDispositivosInteligentesEnPeriodo(periodoA).toString());
    }

    @Test
    public void mostrarConsumoPromedioDispositivo() {
        System.out.println("Consumo promedio del dispositivo " + unDispositivoInteligente.getNombre()
                + ": " + unDispositivoInteligente.consumoPromedio());
    }

    @Test
    public void consumoPromedioTransformadores() {
        System.out.println("Consumo promedio para el transformador en un Periodo: " + transformador1.consumoPromedioEnPeriodo(fecha1, fecha2));
    }

    @Test
    public void recuperarDispositivoAsociado() {
        Transformador transformadorRecuperado = RepoTransformadores.instancia.buscarPorID(transformador1.getId());
        Cliente unCliente = transformadorRecuperado.getClientes().get(0);
        DispositivoInteligente dispositivoInteligente = unCliente.getDispositivosInteligentes().get(0);
        
        System.out.println("Consumo promedio anterior en periodo: "+ dispositivoInteligente.consumoTotal());
        Float consumoAnterior = dispositivoInteligente.getConsumoPorHora();
        dispositivoInteligente.setConsumoPorHora(consumoAnterior * 10.0f);
        System.out.println("Nuevo consumo en periodo del dispositivo inteligente"
        		+ " "+dispositivoInteligente.getNombre() +": "+ dispositivoInteligente.consumoTotal());
        Assert.assertTrue(consumoAnterior < dispositivoInteligente.consumoTotal());
    }

}
