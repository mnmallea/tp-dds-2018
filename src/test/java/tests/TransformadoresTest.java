package tests;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import dominio.Categorizador;
import dominio.Cliente;
import dominio.Direccion;
import dominio.TipoDocumento;
import dominio.Transformador;
import dominio.Zona;
import dominio.dispositivos.DispositivoEstandar;
import dominio.dispositivos.DispositivoInteligente;
import dominio.dispositivos.FabricaDeDispositivos;
import dominio.dispositivos.fabricantes.Fabricante;
import puntos.Point;
import repositorios.AdministradorClientes;
import repositorios.AdministradorTransformadores;
import repositorios.RepoClientes;
import repositorios.RepoTransformadores;
import repositorios.RepoZonas;

public class TransformadoresTest extends AbstractPersistenceTest implements WithGlobalEntityManager {
	Fabricante unFabricante = Mockito.mock(Fabricante.class);
	
	DispositivoInteligente dispoInte1 = FabricaDeDispositivos.crearAire2200("aire2200", unFabricante, 1l);
	DispositivoInteligente dispoInte2 = FabricaDeDispositivos.crearAire3500("aire3500", unFabricante, 1l);
	
	DispositivoEstandar dispoEstan1 = new DispositivoEstandar("dispoEstan1",10f,1f);
	DispositivoEstandar dispoEstan2 = new DispositivoEstandar("dispoEstan2",10f,1f);
	
	List<DispositivoInteligente> listaDispoInteligentes = new LinkedList<>();
	List<DispositivoEstandar> listaDispoEstandar = new LinkedList<>();
	
	Direccion unaDireccion = new Direccion(new Point(2.0,3.0), "unaDireccion");
	Direccion otraDireccion = new Direccion(new Point(49,49), "otraDireccion");

	Zona unaZona = new Zona(10.0,new Point(2.0,2.0));
	
    Cliente cliente =new Cliente("nombre","apellido",TipoDocumento.DNI,123,123,unaDireccion,
    		Categorizador.instancia.getR1(),listaDispoInteligentes,listaDispoEstandar,LocalDate.now(),null);

    
    Cliente cliente2 =new Cliente("otroNombre","otroApellido",TipoDocumento.DNI,123,123,otraDireccion,
    		Categorizador.instancia.getR1(),listaDispoInteligentes,listaDispoEstandar,LocalDate.now(),null);
    
    private Transformador transformador1 = new Transformador(new Point(1, 0));
    private Transformador transformador2 = new Transformador(new Point(50, 50)); //esta fuera del area cubierta por la zona
    private List<Transformador> transformadores = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

//    @Before
    public void setup() {
    	super.setup();
//        Mockito.when(cliente.consumo()).thenReturn(100.0f);
//        Mockito.when(cliente2.consumo()).thenReturn(50.0f);
//        Mockito.when(cliente.getDireccion()).thenReturn(new Direccion(new Point(0, 0), "Calle"));
//        Mockito.when(cliente2.getDireccion()).thenReturn(new Direccion(new Point(51, 50), "Calle"));
        listaDispoInteligentes.add(dispoInte1);
        listaDispoInteligentes.add(dispoInte2);
        listaDispoEstandar.add(dispoEstan1);
        listaDispoEstandar.add(dispoEstan2);
//        Mockito.when(unFabricante.consumoUltimoMes(1l)).thenReturn(5f);
        
        
        clientes.add(cliente);
        clientes.add(cliente2);
        
        RepoClientes.instancia.guardarCliente(cliente);
        RepoClientes.instancia.guardarCliente(cliente2);
        RepoTransformadores.instancia.agregarTransformadores(transformadores);
        
//        AdministradorClientes.instancia.agregarCliente(cliente2);
//        System.out.println("cantidad de clientes");
        System.out.println("CANTIDAD DE CLIENTES ADM: " + AdministradorClientes.instancia.getClientes().size());
        System.out.println("CANTIDAD DE CLIENTES REPO: " + RepoClientes.instancia.getClientes().size());
        System.out.println("cantidad de clientes q van al 1: " + AdministradorClientes.instancia.inicializarClientes(transformador1).size());
        System.out.println("cantidad de clientes q van al 2: " + AdministradorClientes.instancia.inicializarClientes(transformador2).size());

//        transformadores.add(transformador1);
//        transformadores.add(transformador2);
//        unaZona.setTransformadores(transformadores);
        
//        transformador1.setClientes(clientes);
        
        
        unaZona.setTransformadores(AdministradorTransformadores.instancia.inicializarTransformadores(unaZona));

    }


    @Test
    public void elConsumoDeLaZonaEs610() {
        Assert.assertEquals(610.0, unaZona.consumoTotal(), 0.05);
    }


    @Test
    public void elConsumoDelTransformador1DebeSer610() {
		Assert.assertEquals(610d, transformador1.energiaSuministrada(),0);
    }

}
