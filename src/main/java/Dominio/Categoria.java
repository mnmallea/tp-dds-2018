package Dominio;

public class Categoria {
	public Float cargoFijo;
	public Float cargoVariable;
	
	public Categoria(Float cargoFijo, Float cargoVariable) {
		super();
		this.cargoFijo = cargoFijo;
		this.cargoVariable = cargoVariable;
	}

	public Float facturaEstimada(Float unConsumo) {
		return this.cargoFijo + unConsumo*this.cargoVariable;
	}

}
