package actuadores.sensoresConcretos;

import actuadores.reglasConcretas.ReglaParaMovimiento;

import java.util.List;

public class SensorMovimiento {
    private List<ReglaParaMovimiento> reglas;

    public SensorMovimiento(List<ReglaParaMovimiento> reglas) {
        this.reglas = reglas;
    }

    public void agregarRegla(ReglaParaMovimiento unaRegla) {
        reglas.add(unaRegla);
    }

    public void seMovio() {
        reglas.forEach(ReglaParaMovimiento::huboMovimiento);
    }


}
