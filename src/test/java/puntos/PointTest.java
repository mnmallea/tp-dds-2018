package puntos;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

	@Test
	public void laDistanciaEntreDosPuntosIgualesDebeSer0() {
		Point unPunto = new Point(20, 20);
		Point otroPunto = new Point(20, 20);
		Assert.assertEquals(0.0, unPunto.distance(otroPunto), 0.5);
	}

	@Test
	public void laDistanciaEntreUnPuntoNegativoDebeSerPositiva() {
		Point punto = new Point(-20, 0);
		Assert.assertEquals(20, new Point(0, 0).distance(punto), 0.5);
	}

	@Test
	public void testDistanciaEntreDosPuntosRandom() {
		Point punto = new Point(320.25, -41.2);
		Point otroPunto = new Point(150, 7);
		Assert.assertEquals(176.9415, punto.distance(otroPunto), 0.0001);
	}

	@Test
	public void laDistanciaEsConmutativa(){
		Point unPunto = new Point(15949.2,-148);
		Point otroPunto = new Point(-20,750000);
		Double distancia1 = unPunto.distance(otroPunto);
		Double distancia2 = otroPunto.distance(unPunto);
		Assert.assertEquals(distancia1, distancia2);
	}
}