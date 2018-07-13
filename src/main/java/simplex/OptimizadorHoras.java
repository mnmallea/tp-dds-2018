package simplex;

import dominio.Cliente;
import dominio.Dispositivo;
import org.apache.commons.math3.optim.MaxIter;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.*;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import java.util.*;

public class OptimizadorHoras {

	public static final double CONSUMO_MAX_HOGAR = 612;
	private static final int MAX_ITERATIONS = 100;

	public void optimizarCliente(Cliente cliente) {
		List<Dispositivo> dispositivos = cliente.getDispositivos();
		List<SolucionSimplex> soluciones = optimizarHorasUso(dispositivos);
		cliente.notificarResultadoSimplex(soluciones);
	}

	public List<SolucionSimplex> optimizarHorasUso(List<Dispositivo> dispositivos) {
		SimplexSolver simplexSolver = new SimplexSolver();

		OptimizationData funcion = this.generarFuncion(dispositivos);

		Collection<LinearConstraint> setRestricciones = this.obtenerRestriccionesHoras(dispositivos);

		LinearConstraint restriccionConsumoMaximo = this.obtenerRestriccionConumoMaximo(dispositivos);

		Collections.addAll(setRestricciones, restriccionConsumoMaximo);

		OptimizationData restricciones = new LinearConstraintSet(setRestricciones);

		OptimizationData iteracionesMaximas = new MaxIter(MAX_ITERATIONS);

		PointValuePair pointValuePair = simplexSolver.optimize(funcion, restricciones, iteracionesMaximas,
				GoalType.MAXIMIZE, new NonNegativeConstraint(true));

		double[] resultados = pointValuePair.getPoint();

		return this.zipDispositivosYResultados(dispositivos, resultados);
	}

	private List<SolucionSimplex> zipDispositivosYResultados(List<Dispositivo> dispositivos, double[] resultados) {
		List<SolucionSimplex> soluciones = new ArrayList<>();

		for (int i = 0; i < dispositivos.size(); i++) {
			soluciones.add(new SolucionSimplex(dispositivos.get(i), resultados[i]));
		}

		return soluciones;
	}

	private LinearConstraint obtenerRestriccionConumoMaximo(List<Dispositivo> dispositivos) {
		double[] potencias = dispositivos.stream().mapToDouble(Dispositivo::getConsumo).toArray();
		return new LinearConstraint(potencias, Relationship.LEQ, CONSUMO_MAX_HOGAR);
	}

	private Collection<LinearConstraint> obtenerRestriccionesHoras(List<Dispositivo> dispositivos) {
		Collection<LinearConstraint> linearConstraints = new ArrayList<>();

		dispositivos
				.forEach(dispositivo -> this.agregarRestriccionesHoras(dispositivo, linearConstraints, dispositivos));

		return linearConstraints;
	}

	private void agregarRestriccionesHoras(Dispositivo dispositivo, Collection<LinearConstraint> linearConstraints,
			List<Dispositivo> dispositivos) {
		int cantidadDispositivos = dispositivos.size();
		int index = dispositivos.indexOf(dispositivo);
		double horasMaxima = dispositivo.getHorasMaximas();
		double horasMinima = dispositivo.getHorasMinimas();

		double[] coeficientes = obtenerArrayConCoeficienteEnIndex(cantidadDispositivos, index, 1);
		linearConstraints.add(new LinearConstraint(coeficientes, Relationship.LEQ, horasMaxima));
		linearConstraints.add(new LinearConstraint(coeficientes, Relationship.GEQ, horasMinima));

	}

	private double[] obtenerArrayConCoeficienteEnIndex(int size, int index, double coeficiente) {
		double[] coeficientes = new double[size];
		Arrays.fill(coeficientes, 0);
		coeficientes[index] = coeficiente;
		return coeficientes;
	}

	private LinearObjectiveFunction generarFuncion(List<Dispositivo> dispositivos) {
		double[] coeficientes = new double[dispositivos.size()];
		Arrays.fill(coeficientes, 1);
		return new LinearObjectiveFunction(coeficientes, 0);
	}
}
