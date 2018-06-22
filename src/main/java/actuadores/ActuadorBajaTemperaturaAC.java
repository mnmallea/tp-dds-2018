package actuadores;

import dominio.AireAcondicionadoInteligente;

public class ActuadorBajaTemperaturaAC implements Actuador<AireAcondicionadoInteligente> {
	private Integer gradosQueBaja;

	public ActuadorBajaTemperaturaAC(Integer gradosQueBaja) {
		this.gradosQueBaja = gradosQueBaja;
	}

	@Override
	public void actuaSobre(AireAcondicionadoInteligente unAire) {
		unAire.bajarTemperatura(this.gradosQueBaja);
	}
}