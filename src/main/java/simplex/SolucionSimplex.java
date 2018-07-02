package simplex;

import dominio.Dispositivo;

public class SolucionSimplex {
	private Dispositivo dispositivo;
	private double horasRecomendadas;

	public SolucionSimplex(Dispositivo dispositivo, double horasRecomendadas) {
		this.dispositivo = dispositivo;
		this.horasRecomendadas = horasRecomendadas;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public double getHorasRecomendadas() {
		return horasRecomendadas;
	}

	public double getConsumoQueProvocaria(){
		return this.horasRecomendadas * this.dispositivo.getPotencia();
	}
}
