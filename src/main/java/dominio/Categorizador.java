package dominio;

import java.util.Arrays;
import java.util.List;

public class Categorizador {
	
	//Tipos de categoria que puede adoptar un cliente
	static final Categoria r1 = new Categoria(18.76f, 0.644f, 0f, 150f);
	static final Categoria r2 = new Categoria(35.32f, 0.644f, 150f, 325f);
	static final Categoria r3 = new Categoria(60.71f, 0.681f, 325f, 400f);
	static final Categoria r4 = new Categoria(71.74f, 0.738f, 400f, 450f);
	static final Categoria r5 = new Categoria(110.38f, 0.794f, 450f, 500f);
	static final Categoria r6 = new Categoria(220.75f, 0.832f, 500f, 600f);
	static final Categoria r7 = new Categoria(443.59f, 0.851f, 600f, 700f);
	static final Categoria r8 = new Categoria(545.96f, 0.851f, 700f, 1400f);
	static final Categoria r9 = new CategoriaMaxima(887.19f, 0.851f, 1400f);
	//-----------------------------------------------
	
	private List<Categoria> categorias;
	private static Categorizador instancia;
	
	private Categorizador() {
		super();
		categorias = Arrays.asList(r1,r2,r3,r4,r5,r6,r7,r8,r9);
	}
	
	public static Categorizador getInstanceOf() {
		if(instancia == null)
			instancia = new Categorizador();
		return instancia;
	}
	
	public Categoria getCategoriaSegunRango(Float unConsumo) {
		return this.categorias.stream().filter(categoria -> categoria.perteneceACategoria(unConsumo)).findFirst().get();
	}
}
