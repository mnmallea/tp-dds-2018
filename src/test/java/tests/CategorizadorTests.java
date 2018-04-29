package tests;

import org.junit.Assert;
import org.junit.Test;

import dominio.Categorizador;

public class CategorizadorTests {

	@Test
	public void elConsumoFue1500YDeberiaQuedarEnLaCategoriaR9() {
		Assert.assertSame(Categorizador.getInstanceOf().getR9(), Categorizador.getInstanceOf().getCategoriaSegunRango(1500f));
	}
	
	@Test(expected=RuntimeException.class)
	public void elConsumoEsMenorA0YDeberiaFallar() {
		Categorizador.getInstanceOf().getCategoriaSegunRango(-45f);
	}
	
	@Test
	public void elConsumoFue475con75YDeberiaDevolverCategoriaR5(){
		Assert.assertSame(Categorizador.getInstanceOf().getR5(), Categorizador.getInstanceOf().getCategoriaSegunRango(475.75f));
	}
	
	@Test
	public void elConsumoFue0YDeberiaDevolverCategoriaR1() {
		Assert.assertSame(Categorizador.getInstanceOf().getR1(), Categorizador.getInstanceOf().getCategoriaSegunRango(0f));
	}
}
