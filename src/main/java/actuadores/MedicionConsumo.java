package actuadores;

import dominio.DispositivoInteligente;

public class MedicionConsumo extends Medicion {
	public MedicionConsumo(DispositivoInteligente dispositivo, Float consumo) {
		super(new Apagarse(), dispositivo);
		this.consumo = consumo;
	}

	private Float consumo;

	@Override
	public Boolean debeDesencadenarAccion() {
		return this.consumo > 100;
	}

}
