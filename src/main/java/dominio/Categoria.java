package dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
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

    public Categoria() {
    }

    public Float facturaEstimada(Float unConsumo) {
        return this.cargoFijo + unConsumo * this.cargoVariable;
    }

    public Boolean perteneceACategoria(Float unConsumo) {
        return unConsumo >= this.topeInferior && unConsumo < this.topeSuperior;
    }
    @GeneratedValue
    @Id
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
