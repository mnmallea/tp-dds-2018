package db;

import dominio.Transformador;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import puntos.Point;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TransformadoresTest {

    private EntityManager em;
    private EntityTransaction entityTransaction;
    private Transformador transformador1;
    private Transformador transformador2;
    private Transformador transformador3;


    @Before
    public void before() {
        em = PerThreadEntityManagers.getEntityManager();
        entityTransaction = em.getTransaction();
        entityTransaction.begin();

        transformador1 = new Transformador(new Point(0.00, 9.00));
        transformador2 = new Transformador(new Point(10.00, 0.00));
        transformador3 = new Transformador(new Point(-4.00, 9.00));

        em.persist(transformador1);
        em.persist(transformador2);
        em.persist(transformador3);


    }

    @After
    public void after() {
        entityTransaction.rollback();
    }

    @Test
    public void recuperarTransformadores(){

        Assert.assertEquals(3, em.createQuery("select t from Transformador t").getResultList().size());
    }

}
