package actuadores;

import java.util.List;

public class SensorTemperatura implements SensorTemperaturaFabricante {
    private List<ReglaParaTemperatura> reglas;

    public SensorTemperatura(List<ReglaParaTemperatura> reglas) {
        this.reglas = reglas;
    }

    public void agregarRegla(ReglaParaTemperatura unaRegla) {
        reglas.add(unaRegla);
    }

    @Override
    public void laTemperaturaCambioA(Double temperatura) {
        reglas.forEach(regla -> regla.temperaturaCambioA(temperatura));
    }

}
