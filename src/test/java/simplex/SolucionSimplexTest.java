package simplex;

import dominio.dispositivos.DispositivoInteligente;
import dominio.dispositivos.fabricantes.Fabricante;
import dominio.estados.Apagado;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class SolucionSimplexTest {

    Fabricante fabricante = Mockito.mock(Fabricante.class);
    Fabricante fabricanteFallado = Mockito.mock(Fabricante.class);
    DispositivoInteligente dispositivo = new DispositivoInteligente("tele", new Apagado(), 30f, fabricante, 1l);

    EfectoSimplex efectoSimplex = new ApagarSimplex();
    EfectoSimplex efectoSimplex2 = new AhorrarEnergiaSimplex();
    SolucionSimplex solucion = new SolucionSimplex(dispositivo, 2d);

    @Test
    public void aplicarEfectosiDebeApagar() {
        solucion.aplicarEfectoSiDebe(efectoSimplex);
        Assert.assertEquals(false, dispositivo.estaEncendido());
    }

    @Test
    public void aplicarEfectosiDebeEncender() {
        solucion.aplicarEfectoSiDebe(efectoSimplex2);
        Assert.assertEquals(Apagado.class, dispositivo.getEstado());
    }
}