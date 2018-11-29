package tests;

import dominio.Categorizador;
import org.junit.Assert;
import org.junit.Test;

public class CategorizadorTests {

	@Test
	public void elConsumoFue1500YDeberiaQuedarEnLaCategoriaR9() {
		Assert.assertSame(Categorizador.instancia.getR9(), Categorizador.instancia.getCategoriaSegunRango(1500f));
	}
	
	@Test(expected=RuntimeException.class)
	public void elConsumoEsMenorA0YDeberiaFallar() {
		Categorizador.instancia.getCategoriaSegunRango(-45f);
	}
	
	@Test
	public void elConsumoFue475con75YDeberiaDevolverCategoriaR5(){
		Assert.assertSame(Categorizador.instancia.getR5(), Categorizador.instancia.getCategoriaSegunRango(475.75f));
	}
	
	@Test
	public void elConsumoFue0YDeberiaDevolverCategoriaR1() {
		Assert.assertSame(Categorizador.instancia.getR1(), Categorizador.instancia.getCategoriaSegunRango(0f));
	}
}
