package simplex;

import dominio.Dispositivo;
import dominio.EfectoSimplex;

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
		return this.horasRecomendadas * this.dispositivo.getConsumo();
	}
	
	public boolean estuvoPrendidoMuchasHoras() {
		return dispositivo.getHorasUsoMes() > this.horasRecomendadas;
	}

	public void aplicarEfectoSiDebe(EfectoSimplex efectoSimplex) {
		if(this.estuvoPrendidoMuchasHoras()) {
			efectoSimplex.aplicarseA(dispositivo);
		}
	}
}
