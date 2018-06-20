package actuadores;

import dominio.DispositivoInteligente;

public class ReglaParaTemperatura implements ReglaParaTemperaturaFabricante {
	private DispositivoInteligente dispositivo;
	private Actuador actuador;

	public ReglaParaTemperatura(DispositivoInteligente dispositivo, Actuador actuador) {
		this.dispositivo = dispositivo;
		this.actuador = actuador;
	}

	@Override
	public void temperaturaCambioA(Double temperatura) {
		if (temperatura > 24) {
			actuador.actuaSobre(dispositivo);
		}
	}

}