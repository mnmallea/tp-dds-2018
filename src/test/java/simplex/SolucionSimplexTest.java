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

    EfectoSimplex efectoSimplex = EfectoSimplex.APAGAR;
    EfectoSimplex efectoSimplex2 = EfectoSimplex.AHORRAR_ENERGIA;
    EfectoSimplex efectoSimplex3 = EfectoSimplex.NO_HACER_NADA;
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