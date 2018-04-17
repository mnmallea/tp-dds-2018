package Dominio;

public abstract class Categoria {
	public Float cargoVariable;
	public Float cargoFijo;
		
	public Float estimarFactura(Float unConsumo) {
		return this.cargoFijo + unConsumo*this.cargoVariable;
	}
}
