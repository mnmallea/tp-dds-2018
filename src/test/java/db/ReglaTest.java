package db;

import actuadores.Actuador;
import actuadores.Regla;
import actuadores.actuadoresConcretos.ActuadorEncenderDispositivo;
import actuadores.condicionesConcretas.TemperaturaMayorA;
import actuadores.reglasConcretas.ReglaEnciendeAire;
import dominio.dispositivos.AireAcondicionadoInteligente;
import dominio.dispositivos.fabricantes.FabricanteAireAcondicionado;
import dominio.estados.Apagado;
import dominio.estados.Encendido;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import repositorios.RepoReglas;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class ReglaTest {

    private Regla regla;
    private Actuador actuadorEncenderDispositivo;
    private List<Actuador<AireAcondicionadoInteligente>> actuadores = new ArrayList<>();
    private AireAcondicionadoInteligente ac;

    @Before
    public void before() {

        actuadorEncenderDispositivo = new ActuadorEncenderDispositivo();
        actuadores.add(actuadorEncenderDispositivo);

        FabricanteAireAcondicionado fabricanteAireAcondicionado = Mockito.mock(FabricanteAireAcondicionado.class);
        ac = new AireAcondicionadoInteligente("MyAC", new Apagado(), 32f, fabricanteAireAcondicionado, 1L);

        regla = new ReglaEnciendeAire(new TemperaturaMayorA(24d), actuadores, ac);
        RepoReglas.instancia.agregarRegla(regla);
    }

    @Test
    public void ejecutarRegla() {

        Assert.assertEquals(regla, RepoReglas.instancia.buscarReglaPorId(regla.getId()));

        regla.seTomoMedicion(25d);

        Assert.assertEquals(Encendido.class, ac.getEstado().getClass());
    }

    @Test
    public void modificarCondicion() {
        regla.setCondicion(new TemperaturaMayorA(30d));

        Assert.assertEquals(regla.getCondicion(), regla.getCondicion());

        regla.seTomoMedicion(25d);

        Assert.assertEquals(Apagado.class, ac.getEstado().getClass());
    }
}
