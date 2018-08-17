package simplex;

import dominio.dispositivos.DispositivoInteligente;
import dominio.dispositivos.fabricantes.Fabricante;
import dominio.estados.Apagado;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class SolucionSimplexTest {

    Fabricante fabricante = Mockito.mock(Fabricante.class);
    DispositivoInteligente dispositivo = new DispositivoInteligente<>("tele", new Apagado(), 30f, fabricante, 1l);

    EfectoSimplex efectoSimplex = new ApagarSimplex();
    EfectoSimplex efectoSimplex2 = new AhorrarEnergiaSimplex();
    EfectoSimplex efectoSimplex3 = new NoHacerNadaSimplex();
    SolucionSimplex solucion = new SolucionSimplex(dispositivo, 2d);

    @Test
    public void aplicarEfectosiDebeApagar() {
        solucion.aplicarEfectoSiDebe(efectoSimplex);
        Assert.assertFalse(dispositivo.estaEncendido());
    }

    @Test
    public void aplicarEfectosiDebeEncender() {
        solucion.aplicarEfectoSiDebe(efectoSimplex2);
        Assert.assertTrue(dispositivo.getEstado().estaApagado());
    }

    @Test
    public void aplicarEfectoSiDebeAhorroEnergia(){
        solucion.aplicarEfectoSiDebe(efectoSimplex3);
        Assert.assertFalse(dispositivo.getEstado().estaAhorroEnergia());
    }
}