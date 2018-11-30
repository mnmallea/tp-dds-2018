package reportesUtils;

import dominio.dispositivos.DispositivoInteligente;

public class ConsumoPromedio {
    private String nombreDispositivo;
    private Float consumoPromedio;

    public ConsumoPromedio(DispositivoInteligente dispositivoInteligente){
        this.nombreDispositivo = dispositivoInteligente.getNombre();
        this.consumoPromedio = dispositivoInteligente.consumoPromedio();
    }

    public String getNombreDispositivo() {
        return nombreDispositivo;
    }

    public Float getConsumoPromedio() {
        return consumoPromedio;
    }
}
