package tests;

import actuadores.Actuador;
import actuadores.Regla;
import actuadores.Sensor;
import actuadores.actuadoresConcretos.ActuadorBajaTemperaturaAC;
import actuadores.actuadoresConcretos.ActuadorEncenderDispositivo;
import actuadores.condicionesConcretas.TemperaturaMayorA;
import actuadores.reglasConcretas.ReglaBajaTemperatura;
import actuadores.reglasConcretas.ReglaEnciendeAire;
import actuadores.sensoresConcretos.SensorTemperatura;
import dominio.dispositivos.AireAcondicionadoInteligente;
import dominio.dispositivos.fabricantes.FabricanteAireAcondicionado;
import dominio.estados.Apagado;
import dominio.estados.Encendido;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;

public class AireTest {
    private Actuador<AireAcondicionadoInteligente> actuadorEnciendeAire;
    private Actuador<AireAcondicionadoInteligente> actuadorBajaTemperatura;
    private Regla<Double, AireAcondicionadoInteligente> reglaParaEncenderAire;
    private Regla<Double, AireAcondicionadoInteligente> reglaParaBajarTemperatura;
    private AireAcondicionadoInteligente aire;
    private FabricanteAireAcondicionado fabricante;
    private Sensor<Double> sensor;

    @SuppressWarnings("unchecked")
    @Before
    public void init() {
        fabricante = Mockito.mock(FabricanteAireAcondicionado.class);
        aire = new AireAcondicionadoInteligente("Aire LG", new Apagado(), 65.0f, fabricante, 1L);
        actuadorEnciendeAire = new ActuadorEncenderDispositivo<>();
        reglaParaEncenderAire = new ReglaEnciendeAire(new TemperaturaMayorA(24d), Collections.singletonList(actuadorEnciendeAire), aire);
        actuadorBajaTemperatura = new ActuadorBajaTemperaturaAC(3);
        reglaParaBajarTemperatura = new ReglaBajaTemperatura(new TemperaturaMayorA(24d), Collections.singletonList(actuadorBajaTemperatura), aire);
        sensor = new SensorTemperatura(new ArrayList<>());
    }

    @Test
    public void elAireSeDebeEncender() {
        sensor.agregarRegla(reglaParaEncenderAire);
        sensor.informarMedicion(25.0);
        Assert.assertEquals(Encendido.class, aire.getEstado().getClass());
    }

    @Test
    public void elFabricanteDelAireDebioSerLlamadoASuMetodoEncender() {
        sensor.agregarRegla(reglaParaEncenderAire);
        sensor.informarMedicion(25.0);
        Mockito.verify(fabricante, Mockito.times(1)).encenderDispositivo(aire.getIdDeFabrica());
    }

    @Test
    public void elAireDebeQuedarApagado() {
        sensor.agregarRegla(reglaParaBajarTemperatura);
        sensor.informarMedicion(23.2);
        Assert.assertEquals(Apagado.class, aire.getEstado().getClass());
    }

    @Test
    public void laTemperaturaDebioBajar3Grados() {
        sensor.agregarRegla(reglaParaBajarTemperatura);
        sensor.informarMedicion(25.0);
        Mockito.verify(fabricante, Mockito.times(1)).bajarTemperatura(aire.getIdDeFabrica(), 3);
    }

}
