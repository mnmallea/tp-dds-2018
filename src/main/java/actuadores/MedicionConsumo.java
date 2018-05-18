package actuadores;

import dominio.Dispositivo;

public class MedicionConsumo extends Medicion {
	public MedicionConsumo(Dispositivo dispositivo, Float consumo) {
		super(new Apagarse(), dispositivo);
		this.consumo = consumo;
	}

	private Float consumo;

	@Override
	public Boolean debeDesencadenarAccion() {
		return this.consumo > 100;
	}

}
