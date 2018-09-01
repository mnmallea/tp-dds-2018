package actuadores;

public class TemperaturaMayorA implements Condicion<Double> {
    private Double temperatura;

    public TemperaturaMayorA(Double temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public boolean seCumple(Double medicion) {
        return medicion > this.temperatura;
    }
}
