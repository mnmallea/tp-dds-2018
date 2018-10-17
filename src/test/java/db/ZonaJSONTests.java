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
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;
import puntos.Point;
import repositorios.RepoTransformadores;

public class ZonaJSONTests extends AbstractPersistenceTest implements WithGlobalEntityManager {

	@Test
	public void seRecuperanLosTransformadoresDesdeJSONYLaDB() {
		List<Transformador> transformadores = Arrays.asList(ParserTransformadores.obtenerTransformadores("src/main/resources/transformadores.json"));
		RepoTransformadores.instancia.persistirSiDebe(transformadores);

		Assert.assertEquals(3, RepoTransformadores.instancia.getTransformadores().size());

		List<Transformador> transformadoresRenovados = Arrays.asList(ParserTransformadores.obtenerTransformadores("src/main/resources/transformadores2.json"));
		RepoTransformadores.instancia.persistirSiDebe(transformadoresRenovados);

		Assert.assertEquals(4, RepoTransformadores.instancia.getTransformadores().size());

	}

}
