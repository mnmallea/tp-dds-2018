package actuadores;

import java.util.List;

public class SensorMovimiento implements SensorMovimientoFabricante {
    private List<ReglaParaMovimiento> reglas;

    public SensorMovimiento(List<ReglaParaMovimiento> reglas) {
        this.reglas = reglas;
    }

    public void agregarRegla(ReglaParaMovimiento unaRegla) {
        reglas.add(unaRegla);
    }

    @Override
    public void seMovio() {
        reglas.forEach(ReglaParaMovimiento::huboMovimiento);
    }


}
