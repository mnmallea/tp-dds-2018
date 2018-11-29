package db;

import dominio.Transformador;
import jsonAObjeto.ParserTransformadores;
import org.junit.Assert;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;
import repositorios.RepoTransformadores;

import java.util.Arrays;
import java.util.List;

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
