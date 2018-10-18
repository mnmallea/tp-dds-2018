package db;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import actuadores.Actuador;
import actuadores.Regla;
import actuadores.actuadoresConcretos.ActuadorEncenderDispositivo;
import actuadores.condicionesConcretas.TemperaturaMayorA;
import actuadores.reglasConcretas.ReglaEnciendeAire;
import dominio.dispositivos.AireAcondicionadoInteligente;
import dominio.dispositivos.fabricantes.FabricanteAireAcondicionado;
import dominio.estados.Apagado;
import dominio.estados.Encendido;
import repositorios.RepoReglas;

public class ReglaTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

    private Regla regla;
    private Actuador actuadorEncenderDispositivo;
    private List<Actuador<AireAcondicionadoInteligente>> actuadores = new ArrayList<>();
    private AireAcondicionadoInteligente ac;

    public void setup() {
        super.setup();
        actuadorEncenderDispositivo = new ActuadorEncenderDispositivo();
        actuadores.add(actuadorEncenderDispositivo);

        FabricanteAireAcondicionado fabricanteAireAcondicionado = Mockito.mock(FabricanteAireAcondicionado.class);
        ac = new AireAcondicionadoInteligente("MyAC", new Apagado(), 32f, fabricanteAireAcondicionado, 1L);

        regla = new ReglaEnciendeAire(new TemperaturaMayorA(24d), actuadores, ac);

        RepoReglas.instancia.agregarRegla(regla);
        entityManager().persist(ac);//TODO reemplazar por Repo
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
