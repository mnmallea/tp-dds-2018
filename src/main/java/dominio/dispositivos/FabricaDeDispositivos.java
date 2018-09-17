package dominio.dispositivos;

import dominio.dispositivos.fabricantes.Fabricante;
import dominio.estados.Apagado;

public class FabricaDeDispositivos {

    public static final float HORAS_MINIMAS_AIRE = 90f;
    public static final float HORAS_MAXIMAS_AIRE = 360f;
    public static final float HORAS_MINIMAS_LAMPARA = 90f;
    public static final float HORAS_MAXIMAS_LAMPARA = 360f;
    public static final float HORAS_MINIMAS_TELE = 90f;
    public static final float HORAS_MAXIMAS_TELE = 360f;
    public static final float HORAS_MINIMAS_LAVARROPAS = 6f;
    public static final float HORAS_MAXIMAS_LAVARROPAS = 30f;
    public static final float HORAS_MINIMAS_COMPUTADORA = 60f;
    public static final float HORAS_MAXIMAS_COMPUTADORA = 360f;
    public static final float HORAS_MINIMAS_MICROONDAS = 3f;
    public static final float HORAS_MAXIMAS_MICROONDAS = 15f;
    public static final float HORAS_MINIMAS_PLANCHA = 3f;
    public static final float HORAS_MAXIMAS_PLANCHA = 30f;
    public static final float HORAS_MINIMAS_VENTILADOR = 120f;
    public static final float HORAS_MAXIMAS_VENTILADOR = 360f;

    public static DispositivoInteligente crearAire3500(String nombre, Fabricante fabricante, Long id) {
        DispositivoInteligente aire = new DispositivoInteligente<>(nombre, new Apagado(), (float) 1.613, fabricante, id);
        setearHoras(aire, HORAS_MINIMAS_AIRE, HORAS_MAXIMAS_AIRE);
        return aire;
    }

    public static DispositivoInteligente crearAire2200(String nombre, Fabricante fabricante, Long id) {
        DispositivoInteligente aire = new DispositivoInteligente<>(nombre, new Apagado(), (float) 1.013, fabricante, id);
        setearHoras(aire, HORAS_MINIMAS_AIRE, HORAS_MAXIMAS_AIRE);
        return aire;
    }

    public static DispositivoEstandar crearTelevisor21(String nombre, Float horas) {
        DispositivoEstandar tele = new DispositivoEstandar(nombre, (float) 0.075, horas);
        setearHoras(tele, HORAS_MINIMAS_TELE, HORAS_MAXIMAS_TELE);
        return tele;
    }

    public static DispositivoEstandar crearTelevisor29A34(String nombre, Float horas) {
        DispositivoEstandar tele = new DispositivoEstandar(nombre, (float) 0.175, horas);
        setearHoras(tele, HORAS_MINIMAS_TELE, HORAS_MAXIMAS_TELE);
        return tele;
    }

    public static DispositivoEstandar crearLCD40(String nombre, Float horas) {
        DispositivoEstandar tele = new DispositivoEstandar(nombre, (float) 0.18, horas);
        setearHoras(tele, HORAS_MINIMAS_TELE, HORAS_MAXIMAS_TELE);
        return tele;
    }

    public static DispositivoInteligente crearLED24(String nombre, Fabricante fabricante, Long id) {
        DispositivoInteligente tele = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.04, fabricante, id);
        setearHoras(tele, HORAS_MINIMAS_TELE, HORAS_MAXIMAS_TELE);
        return tele;
    }

    public static DispositivoInteligente crearLED32(String nombre, Fabricante fabricante, Long id) {
        DispositivoInteligente tele = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.055, fabricante, id);
        setearHoras(tele, HORAS_MINIMAS_TELE, HORAS_MAXIMAS_TELE);
        return tele;
    }

    public static DispositivoInteligente crearLED40(String nombre, Fabricante fabricante, Long id) {
        DispositivoInteligente tele = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.08, fabricante, id);
        setearHoras(tele, HORAS_MINIMAS_TELE, HORAS_MAXIMAS_TELE);
        return tele;
    }

    public static DispositivoInteligente crearHeladeraConFreezer(String nombre, Fabricante fabricante, Long id) {
        return new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.09, fabricante, id);
    }

    public static DispositivoInteligente crearHeladeraSinFreezer(String nombre, Fabricante fabricante, Long id) {
        return new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.075, fabricante, id);
    }

    public static DispositivoEstandar crearLavarropasAutomatico5KgAguaCaliente(String nombre, Float horas) {
        DispositivoEstandar lavarropas = new DispositivoEstandar(nombre, (float) 0.875, horas);
        setearHoras(lavarropas, HORAS_MINIMAS_LAVARROPAS, HORAS_MAXIMAS_LAVARROPAS);
        return lavarropas;
    }

    public static DispositivoEstandar crearLavarropasSemiAutomatico5Kg(String nombre, Float horas) {
        DispositivoEstandar lavarropas = new DispositivoEstandar(nombre, (float) 0.1275, horas);
        setearHoras(lavarropas, HORAS_MINIMAS_LAVARROPAS, HORAS_MAXIMAS_LAVARROPAS);
        return lavarropas;
    }

    public static DispositivoInteligente crearLavarropasAutomatico5Kg(String nombre, Fabricante fabricante, Long id) {
        DispositivoInteligente lavarropas = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.175, fabricante, id);
        setearHoras(lavarropas, HORAS_MINIMAS_LAVARROPAS, HORAS_MAXIMAS_LAVARROPAS);
        return lavarropas;
    }

    public static DispositivoInteligente crearVentiladorTecho(String nombre, Fabricante fabricante, Long id) {
        DispositivoInteligente ventilador = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.06, fabricante, id);
        setearHoras(ventilador, HORAS_MINIMAS_VENTILADOR, HORAS_MAXIMAS_VENTILADOR);
        return ventilador;
    }

    public static DispositivoEstandar crearVentiladorDePie(String nombre, Float horas) {
        DispositivoEstandar ventilador = new DispositivoEstandar(nombre, (float) 0.09, horas);
        setearHoras(ventilador, HORAS_MINIMAS_VENTILADOR, HORAS_MAXIMAS_VENTILADOR);
        return ventilador;
    }

    public static DispositivoInteligente crearLamparaHalogena40(String nombre, Fabricante fabricante, Long id) {
        DispositivoInteligente lampara = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.04, fabricante, id);
        setearHoras(lampara, HORAS_MINIMAS_LAMPARA, HORAS_MAXIMAS_LAMPARA);
        return lampara;
    }

    public static DispositivoInteligente crearLamparaHalogena60(String nombre, Fabricante fabricante, Long id) {
        DispositivoInteligente lampara = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.06, fabricante, id);
        setearHoras(lampara, HORAS_MINIMAS_LAMPARA, HORAS_MAXIMAS_LAMPARA);
        return lampara;
    }

    public static DispositivoInteligente crearLamparaHalogena100(String nombre, Fabricante fabricante, Long id) {
        DispositivoInteligente lampara = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.015, fabricante, id);
        setearHoras(lampara, HORAS_MINIMAS_LAMPARA, HORAS_MAXIMAS_LAMPARA);
        return lampara;
    }

    public static DispositivoInteligente crearLampara11W(String nombre, Fabricante fabricante, Long id) {
        DispositivoInteligente lampara = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.011, fabricante, id);
        setearHoras(lampara, HORAS_MINIMAS_LAMPARA, HORAS_MAXIMAS_LAMPARA);
        return lampara;
    }

    public static DispositivoInteligente crearLampar15W(String nombre, Fabricante fabricante, Long id) {
        DispositivoInteligente lampara = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.015, fabricante, id);
        setearHoras(lampara, HORAS_MINIMAS_LAMPARA, HORAS_MAXIMAS_LAMPARA);
        return lampara;
    }

    public static DispositivoInteligente crearLampara20W(String nombre, Fabricante fabricante, Long id) {
        DispositivoInteligente lampara = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.02, fabricante, id);
        setearHoras(lampara, HORAS_MINIMAS_LAMPARA, HORAS_MAXIMAS_LAMPARA);
        return lampara;
    }

    public static DispositivoInteligente crearPCEscritorio(String nombre, Fabricante fabricante, Long id) {
        DispositivoInteligente pc = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.4, fabricante, id);
        setearHoras(pc, HORAS_MINIMAS_COMPUTADORA, HORAS_MAXIMAS_COMPUTADORA);
        return pc;
    }

    public static DispositivoEstandar crearMicroondas(String nombre, Float horas) {
        DispositivoEstandar microondas = new DispositivoEstandar(nombre, (float) 0.64, horas);
        setearHoras(microondas, HORAS_MINIMAS_MICROONDAS, HORAS_MAXIMAS_MICROONDAS);
        return microondas;
    }

    public static DispositivoEstandar crearPlancha(String nombre, Float horas) {
        DispositivoEstandar plancha = new DispositivoEstandar(nombre, (float) 0.75, horas);
        setearHoras(plancha, HORAS_MINIMAS_PLANCHA, HORAS_MAXIMAS_PLANCHA);
        return plancha;
    }

    private static void setearHoras(Dispositivo dispositivo, float horasMinimas, float horasMaximas) {
        dispositivo.setHorasMinimas(horasMinimas);
        dispositivo.setHorasMaximas(horasMaximas);
    }

}
