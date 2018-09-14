package db;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import dominio.Transformador;
import dominio.Zona;
import jsonAObjeto.ParserTransformadores;
import puntos.Point;
import repositorios.RepoTransformadores;

public class ZonaJSONTests {

	EntityManager em;
	EntityTransaction entityTransaction;
	Zona zona1;
	Zona zona2;
	Zona zona3;

	@Before
	public void init() {
		em = PerThreadEntityManagers.getEntityManager();
		entityTransaction = em.getTransaction();
		entityTransaction.begin();

		zona1 = new Zona(8.0d, new Point(125.0, 120.0));
		zona1.setId(1L);
		zona2 = new Zona(10.0d, new Point(125.0, 12.0));
		zona2.setId(2L);
		zona3 = new Zona(82.0d, new Point(15.0, 10.0));
		zona3.setId(3L);

		em.persist(zona1);
		em.persist(zona2);
		em.persist(zona3);
	}

	@After
	public void tearDown() {
		entityTransaction.rollback();
	}

	@Test
	public void seRecuperanLosTransformadoresDesdeJSONYLasZonasDesdeLaDB() {
		List<Transformador> transformadores = Arrays.asList(ParserTransformadores.obtenerTransformadores("src/main/resources/transformadores.json"));
		transformadores.forEach(RepoTransformadores::persistirSiDebe);

		Assert.assertEquals(3, em.createQuery("select t from Transformador t").getResultList().size());

		List<Transformador> transformadoresRenovados = Arrays.asList(ParserTransformadores.obtenerTransformadores("src/main/resources/transformadores2.json"));
		transformadoresRenovados.forEach(RepoTransformadores::persistirSiDebe);

		Assert.assertEquals(4, em.createQuery("select t from Transformador t").getResultList().size());

		transformadores.forEach(t -> System.out.println(t.getZona().getId()));
		
		Assert.assertEquals(zona1, transformadores.get(0).getZona());

	}

}
