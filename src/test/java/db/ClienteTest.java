package db;

import dominio.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;
import puntos.Point;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClienteTest {

	private EntityManager em;
	private EntityTransaction entityTransaction;
	private Zona zona1;
	private Zona zona2;
	private Cliente cliente;

	@Before
	public void before() {
		em = PerThreadEntityManagers.getEntityManager();
		entityTransaction = em.getTransaction();
		entityTransaction.begin();

		zona1 = new Zona(45.0, new Point(0.0, 0.0));
		zona1.setId(1L);
		zona2 = new Zona(80.0, new Point(-1.0, 0.0));
		zona2.setId(2L);
		cliente = new Cliente("Julian Ezequiel", "Pico", TipoDocumento.DNI, 401, 456,
				new Direccion(new Point(2.0, 3.0), "Calle 5"), Categorizador.instancia.getR1(), new ArrayList<>(),
				new ArrayList<>(), LocalDate.now(), zona1);
		cliente.setId(1L);
		em.persist(zona1);
		em.persist(zona2);
		em.persist(cliente);

	}

	@After
	public void after() {
		entityTransaction.rollback();
	}

	@Test
	public void crearYRecuperarNuevoUsuario() {
		Assert.assertEquals(cliente, em.find(Cliente.class, 1L));
	}

	@Test
	public void cambiarGeoposicionamientoYRecuperar() {
		cliente.setZona(zona2);

		Assert.assertEquals(zona2, em.find(Cliente.class, 1L).getZona());
	}
}
