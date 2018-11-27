package reportesUtils;

import dominio.Transformador;
import puntos.Point;

public class ReporteTransformador {
    private Transformador transformador;
    private Double consumo;

    public ReporteTransformador(Transformador transformador, Double consumo) {
        this.transformador = transformador;
        this.consumo = consumo;
    }

    public Double getConsumo() {
        return consumo;
    }

    public Long getTransformadorId(){
        return transformador.getId();
    }

    public Point getCoordenadas(){
        return transformador.getCoordenadas();
    }

    public Long getIdEnre(){
        return transformador.getIdEnre();
    }
}
