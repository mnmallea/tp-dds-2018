package dominio;

import java.util.Arrays;
import java.util.List;

public class Categorizador {

	// Cargo fijo segun categoria
	private float cargoFijoR1 = 18.76f;
	private float cargoFijoR2 = 35.32f;
	private float cargoFijoR3 = 60.71f;
	private float cargoFijoR4 = 71.74f;
	private float cargoFijoR5 = 110.38f;
	private float cargoFijoR6 = 220.75f;
	private float cargoFijoR7 = 443.59f;
	private float cargoFijoR8 = 545.96f;
	private float cargoFijoR9 = 887.19f;
	
	// Cargo variable segun categoria
	private float cargoVariableR1 = 0.644f;
	private float cargoVariableR2 = 0.644f;
	private float cargoVariableR3 = 0.681f;
	private float cargoVariableR4 = 0.738f;
	private float cargoVariableR5 = 0.794f;
	private float cargoVariableR6 = 0.832f;
	private float cargoVariableR7 = 0.851f;
	private float cargoVariableR8 = 0.851f;
	private float cargoVariableR9 = 0.851f;
	

	// Tipos de categoria que puede adoptar un cliente
	private Categoria r1 = new CategoriaMinima(cargoFijoR1, cargoVariableR1, 150f);
	private Categoria r2 = new Categoria(cargoFijoR2, cargoVariableR2, 150f, 325f);
	private Categoria r3 = new Categoria(cargoFijoR3, cargoVariableR3, 325f, 400f);
	private Categoria r4 = new Categoria(cargoFijoR4, cargoVariableR4, 400f, 450f);
	private Categoria r5 = new Categoria(cargoFijoR5, cargoVariableR5, 450f, 500f);
	private Categoria r6 = new Categoria(cargoFijoR6, cargoVariableR6, 500f, 600f);
	private Categoria r7 = new Categoria(cargoFijoR7, cargoVariableR7, 600f, 700f);
	private Categoria r8 = new Categoria(cargoFijoR8, cargoVariableR8, 700f, 1400f);
	private Categoria r9 = new CategoriaMaxima(cargoFijoR9, cargoVariableR9, 1400f);
	// -----------------------------------------------

	private List<Categoria> categorias;
	private static Categorizador instancia;

	private Categorizador() {
		super();
		categorias = Arrays.asList(r1, r2, r3, r4, r5, r6, r7, r8, r9);
	}

	public static Categorizador getInstanceOf() {
		if (instancia == null)
			instancia = new Categorizador();
		return instancia;
	}

	public Categoria getCategoriaSegunRango(Float unConsumo) {
		return this.categorias.stream().filter(categoria -> categoria.perteneceACategoria(unConsumo)).findFirst().get();
	}

	public Categoria getR1() {
		return r1;
	}

	public Categoria getR2() {
		return r2;
	}

	public Categoria getR3() {
		return r3;
	}

	public Categoria getR4() {
		return r4;
	}

	public Categoria getR5() {
		return r5;
	}

	public Categoria getR6() {
		return r6;
	}

	public Categoria getR7() {
		return r7;
	}

	public Categoria getR8() {
		return r8;
	}

	public Categoria getR9() {
		return r9;
	}

}
