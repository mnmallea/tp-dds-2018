package dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categoria {
    @Id
    private Long id;

    public Float cargoFijo;
    public Float cargoVariable;
    public Float topeInferior;
    public Float topeSuperior;


    public Categoria(Long id, Float cargoFijo, Float cargoVariable, Float topeInferior, Float topeSuperior) {
        this.id = id;
        this.cargoFijo = cargoFijo;
        this.cargoVariable = cargoVariable;
        this.topeInferior = topeInferior;
        this.topeSuperior = topeSuperior;
    }

    public Categoria() {
    }

    public Float facturaEstimada(Float unConsumo) {
        return this.cargoFijo + unConsumo * this.cargoVariable;
    }

    public Boolean perteneceACategoria(Float unConsumo) {
        return unConsumo >= this.topeInferior && unConsumo < this.topeSuperior;
    }

}
