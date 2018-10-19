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
import repositorios.RepoDispositivosEstandares;
import repositorios.RepoDispositivosInteligentes;
import repositorios.RepoTransformadores;

public class TransformadoresTest extends AbstractPersistenceTest implements WithGlobalEntityManager {
	Fabricante unFabricante = Mockito.mock(Fabricante.class);
	
	DispositivoInteligente dispoInte1 = FabricaDeDispositivos.crearAire2200("aire2200", unFabricante, 1l);
	DispositivoInteligente dispoInte2 = FabricaDeDispositivos.crearAire3500("aire3500", unFabricante, 1l);
	
	private DispositivoEstandar dispoEstan1;
	private DispositivoEstandar dispoEstan2;
	
	private List<DispositivoInteligente> listaDispoInteligentes;
	private List<DispositivoEstandar> listaDispoEstandar;
	
	private Direccion unaDireccion;
	private Direccion otraDireccion;

	private Zona unaZona;
	
	private Cliente cliente;

    
	private Cliente cliente2;
    
    private Transformador transformador1;
    private Transformador transformador2;
    private List<Transformador> transformadores;
    private List<Cliente> clientes;

    @Before
    public void before() {
    	Mockito.when(unFabricante.consumoUltimoMes(1l)).thenReturn(5f);
    	dispoEstan1 = new DispositivoEstandar("dispoEstan1",10f,1f);
    	dispoEstan2 = new DispositivoEstandar("dispoEstan2",10f,1f);
    	
    	listaDispoInteligentes = new LinkedList<>();
    	listaDispoEstandar = new LinkedList<>();
    	listaDispoEstandar.add(dispoEstan1);
        listaDispoEstandar.add(dispoEstan2);
    	listaDispoInteligentes.add(dispoInte1);
    	listaDispoInteligentes.add(dispoInte2);
    	
    	unaDireccion = new Direccion(new Point(1.0,1.0), "unaDireccion");
    	otraDireccion = new Direccion(new Point(10.0,10.0), "otraDireccion");

    	unaZona = new Zona(50.0,new Point(1.0,1.0));
    	
    	cliente =new Cliente("nombre","apellido",TipoDocumento.DNI,123,123,unaDireccion,
        		Categorizador.instancia.getR1(),listaDispoInteligentes,listaDispoEstandar,LocalDate.now(),null);

        
    	cliente2 =new Cliente("otroNombre","otroApellido",TipoDocumento.DNI,123,123,otraDireccion,
        		Categorizador.instancia.getR1(),listaDispoInteligentes,listaDispoEstandar,LocalDate.now(),null);
        
        transformador1 = new Transformador(new Point(1, 0));
        transformador2 = new Transformador(new Point(10, 10)); 
        transformadores = new ArrayList<>();
        clientes = new ArrayList<>();

        transformadores.add(transformador1);
        transformadores.add(transformador2);

        
        RepoTransformadores.instancia.agregarTransformador(transformador1);
        RepoTransformadores.instancia.agregarTransformador(transformador2);
        RepoDispositivosInteligentes.instancia.agregarDispositivoInteligente(dispoInte1);
        RepoDispositivosInteligentes.instancia.agregarDispositivoInteligente(dispoInte2);
        RepoDispositivosEstandares.instancia.agregarDispositivoEstandar(dispoEstan1);
        RepoDispositivosEstandares.instancia.agregarDispositivoEstandar(dispoEstan2);
        RepoClientes.instancia.guardarCliente(cliente);
        RepoClientes.instancia.guardarCliente(cliente2);
                
        transformador1.setClientes(AdministradorClientes.instancia.inicializarClientes(transformador1));
        transformador2.setClientes(AdministradorClientes.instancia.inicializarClientes(transformador2));
        unaZona.setTransformadores(AdministradorTransformadores.instancia.inicializarTransformadores(unaZona));

    }


    @Test
    public void elConsumoDeLaZonaEs20() {
        Assert.assertEquals(1220, unaZona.consumoTotal(), 0.05);
    }


    @Test
    public void elConsumoDelTransformador1DebeSer10() {
		Assert.assertEquals(610, transformador1.energiaSuministrada(),0);
    }

}
