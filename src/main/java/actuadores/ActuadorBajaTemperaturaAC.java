package actuadores;

import dominio.AireAcondicionadoInteligente;
import dominio.DispositivoInteligente;

public class ActuadorBajaTemperaturaAC implements Actuador {
	private Integer gradosQueBaja;

	public ActuadorBajaTemperaturaAC(Integer gradosQueBaja) {
		this.gradosQueBaja = gradosQueBaja;
	}

	@Override
	public void actuaSobre(DispositivoInteligente unDispositivo) {
		AireAcondicionadoInteligente aire = (AireAcondicionadoInteligente) unDispositivo;
		aire.bajarTemperatura(this.gradosQueBaja);
	}
}