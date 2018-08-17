package tests;

import dominio.dispositivos.Dispositivo;
import dominio.dispositivos.FabricaDeDispositivos;
import dominio.dispositivos.fabricantes.Fabricante;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import simplex.OptimizadorHoras;
import simplex.SolucionSimplex;

import java.util.Arrays;
import java.util.List;

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
		Fabricante fabricante = Mockito.mock(Fabricante.class);
		d1 = FabricaDeDispositivos.crearAire2200("Aire", fabricante, 1L);
		d2 = FabricaDeDispositivos.crearLampara11W("Lamparita", fabricante, 2L);
		d3 = FabricaDeDispositivos.crearLED40("Tele", fabricante, 3L);
		d4 = FabricaDeDispositivos.crearPCEscritorio("Compu", fabricante, 4L);
		d5 = FabricaDeDispositivos.crearLavarropasSemiAutomatico5Kg("Lavarropas", 2f);
		d6 = FabricaDeDispositivos.crearMicroondas("Microondas", 2f);
		d7 = FabricaDeDispositivos.crearPlancha("Plancha", 1.5f);
		d8 = FabricaDeDispositivos.crearVentiladorTecho("Ventilador", fabricante, 5L);

		dispositivos = Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8);

	}

	@Test
	public void testPruebaSimplex1() {
		OptimizadorHoras optimizadorHoras = new OptimizadorHoras();
		List<SolucionSimplex> solucion = optimizadorHoras.optimizarHorasUso(dispositivos);
		Assert.assertEquals(solucion.get(0).getHorasRecomendadas(), 360, 0.002);
	}

	@Test
	public void elConsumoTotalEsMenorAlMaximo() {
		OptimizadorHoras optimizadorHoras = new OptimizadorHoras();
		List<SolucionSimplex> soluciones = optimizadorHoras.optimizarHorasUso(dispositivos);

		Double consumoTotal = soluciones.stream().mapToDouble(SolucionSimplex::getConsumoQueProvocaria).sum();

		Assert.assertTrue(consumoTotal <= OptimizadorHoras.CONSUMO_MAX_HOGAR);
	}

	@Test
	public void hayTantosResultadosComoDispositivos() {
		List<Dispositivo> dispositivos = Arrays.asList(d1, d2, d3);
		List<SolucionSimplex> soluciones = new OptimizadorHoras().optimizarHorasUso(dispositivos);

		Assert.assertEquals(dispositivos.size(), soluciones.size());
	}
}
