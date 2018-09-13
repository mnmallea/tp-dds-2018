package actuadores.sensoresConcretos;

import actuadores.reglasConcretas.ReglaParaTemperatura;

import java.util.List;

public class SensorTemperatura {
    private List<ReglaParaTemperatura> reglas;

    public SensorTemperatura(List<ReglaParaTemperatura> reglas) {
        this.reglas = reglas;
    }

    public void agregarRegla(ReglaParaTemperatura unaRegla) {
        reglas.add(unaRegla);
    }

    public void laTemperaturaCambioA(Double temperatura) {
        reglas.forEach(regla -> regla.temperaturaCambioA(temperatura));
    }

}
