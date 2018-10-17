package db;

import dominio.Transformador;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;
import puntos.Point;
import repositorios.RepoTransformadores;

import java.util.Arrays;

public class TransformadoresTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

    private Transformador transformador1;
    private Transformador transformador2;
    private Transformador transformador3;


    @Before
    public void before() {
        transformador1 = new Transformador(new Point(0.00, 9.00));
        transformador2 = new Transformador(new Point(10.00, 0.00));
        transformador3 = new Transformador(new Point(-4.00, 9.00));

    }

    @Test
    public void recuperarTransformadores(){
        RepoTransformadores.instancia.agregarTransformadores(Arrays.asList(transformador1,transformador2,transformador3));
        Assert.assertEquals(3, RepoTransformadores.instancia.getTransformadores().size());
    }

}
