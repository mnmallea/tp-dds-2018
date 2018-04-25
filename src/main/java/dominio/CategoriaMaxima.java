package dominio;

public class CategoriaMaxima extends Categoria{
	public CategoriaMaxima(Float cargoFijo, Float cargoVariable, Float topeInferior) {
		super(cargoFijo,cargoVariable,topeInferior, 0f);
	}
	
	@Override
	public Boolean perteneceACategoria(Float unConsumo) {
		return unConsumo > this.topeInferior;
	}
}
