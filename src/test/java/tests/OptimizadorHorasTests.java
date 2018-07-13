package tests;

import dominio.Dispositivo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import simplex.OptimizadorHoras;
import simplex.SolucionSimplex;

import java.util.Arrays;
import java.util.List;

class DispositivoPrueba implements Dispositivo {
	private Float potencia;
	private Float horasMinimas;
	private Float horasMaximas;

	DispositivoPrueba(Float potencia, Float horasMinimas, Float horasMaximas) {
		this.potencia = potencia;
		this.horasMinimas = horasMinimas;
		this.horasMaximas = horasMaximas;
	}

	@Override
	public Float getConsumo() {
		return potencia;
	}

	@Override
	public Float getHorasMinimas() {
		return horasMinimas;
	}

	@Override
	public Float getHorasMaximas() {
		return horasMaximas;
	}

	@Override
	public Float getHorasUsoMes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void apagarse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ahorrarEnergia() {
		// TODO Auto-generated method stub
		
	}
}

public class OptimizadorHorasTests {
	private List<Dispositivo> dispositivos;
	private Dispositivo d1;
	private Dispositivo d2;
	private Dispositivo d3;
	private Dispositivo d4;
	private Dispositivo d5;
	private Dispositivo d6;
	private Dispositivo d7;
	private Dispositivo d8;

	@Before
	public void setUp() {
		d1 = new DispositivoPrueba(1.013f, 90.0f, 360.0f);
		d2 = new DispositivoPrueba(0.011f, 90.0f, 360.0f);
		d3 = new DispositivoPrueba(0.08f, 90.0f, 360.0f);
		d4 = new DispositivoPrueba(0.4f, 60.0f, 360.0f);
		d5 = new DispositivoPrueba(0.1275f, 6.0f, 30.0f);
		d6 = new DispositivoPrueba(0.64f, 3.0f, 15.0f);
		d7 = new DispositivoPrueba(0.75f, 3.0f, 30.0f);
		d8 = new DispositivoPrueba(0.06f, 120.0f, 360.0f);

		dispositivos = Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8);

	}

	@Test
	public void testPruebaSimplex1() {
		OptimizadorHoras optimizadorHoras = new OptimizadorHoras();
		List<SolucionSimplex> solucion = optimizadorHoras.optimizarHorasUso(dispositivos);
		Assert.assertEquals(solucion.get(0).getHorasRecomendadas(),  360, 0.002);
	}

	@Test
	public void elConsumoTotalEsMenorAlMaximo() {
		OptimizadorHoras optimizadorHoras = new OptimizadorHoras();
		List<SolucionSimplex> soluciones = optimizadorHoras.optimizarHorasUso(dispositivos);

		Double consumoTotal = soluciones.stream().mapToDouble(SolucionSimplex::getConsumoQueProvocaria).sum();

		Assert.assertTrue(consumoTotal <= OptimizadorHoras.CONSUMO_MAX_HOGAR);
	}

	@Test
	public void hayTantosResultadosComoDispositivos(){
		List<Dispositivo> dispositivos = Arrays.asList(d1, d2, d3);
		List<SolucionSimplex> soluciones = new OptimizadorHoras().optimizarHorasUso(dispositivos);

		Assert.assertEquals(dispositivos.size(), soluciones.size());
	}
}
