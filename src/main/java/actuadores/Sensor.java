package actuadores;

import java.util.List;

public class Sensor<T> {
    protected List<Regla<T, ?>> reglas;

    public Sensor(List<Regla<T, ?>> reglas) {
        this.reglas = reglas;
    }

    public void agregarRegla(Regla<T, ?> unaRegla) {
        reglas.add(unaRegla);
    }

    public void informarMedicion(T medicion) {
        reglas.forEach(regla -> regla.seTomoMedicion(medicion));
    }
}
