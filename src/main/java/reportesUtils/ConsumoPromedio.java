package reportesUtils;

import dominio.dispositivos.DispositivoInteligente;

public class ConsumoPromedio {
    private String nombreDispositivo;
    private Double consumoPromedio;

    public ConsumoPromedio(DispositivoInteligente dispositivoInteligente) {
        this.nombreDispositivo = dispositivoInteligente.getNombre();
        Float consumoPromedio = dispositivoInteligente.consumoPromedio();
        this.consumoPromedio = consumoPromedio.doubleValue();
    }

    public String getNombreDispositivo() {
        return nombreDispositivo;
    }

    public Double getConsumoPromedio() {
        return consumoPromedio;
    }
}
