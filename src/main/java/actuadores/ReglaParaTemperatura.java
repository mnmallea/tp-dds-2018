package actuadores;

import dominio.dispositivos.DispositivoInteligente;

public class ReglaParaTemperatura implements ReglaParaTemperaturaFabricante {
    private DispositivoInteligente dispositivo;
    private Actuador actuador;

    public ReglaParaTemperatura(DispositivoInteligente dispositivo, Actuador actuador) {
        this.dispositivo = dispositivo;
        this.actuador = actuador;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void temperaturaCambioA(Double temperatura) {
        if (temperatura > 24) actuador.actuaSobre(dispositivo);
    }

}