package dominio;

public class CategoriaMinima extends Categoria{
	
	public CategoriaMinima(Float cargoFijo, Float cargoVariable, Float topeSuperior) {
		super(cargoFijo,cargoVariable,0f, topeSuperior);
	}
	
	@Override
	public Boolean perteneceACategoria(Float unConsumo) {
		return unConsumo>=0 && unConsumo < topeSuperior;
	}

}
