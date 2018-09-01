package dominio;

public class Categoria {
    public Float cargoFijo;
    public Float cargoVariable;
    public Float topeInferior;
    public Float topeSuperior;

    public Categoria(Float cargoFijo, Float cargoVariable, Float topeInferior, Float topeSuperior) {
        this.cargoFijo = cargoFijo;
        this.cargoVariable = cargoVariable;
        this.topeInferior = topeInferior;
        this.topeSuperior = topeSuperior;
    }

    public Float facturaEstimada(Float unConsumo) {
        return this.cargoFijo + unConsumo * this.cargoVariable;
    }

    public Boolean perteneceACategoria(Float unConsumo) {
        return unConsumo >= this.topeInferior && unConsumo < this.topeSuperior;
    }

}
