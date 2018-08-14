package dominio.dispositivos;

import dominio.dispositivos.fabricantes.Fabricante;
import dominio.estados.Apagado;

public class FabricaDeDispositivos {

    public static Dispositivo crearAire3500(String nombre, Fabricante fabricante, Long id){
        return new DispositivoInteligente<>(nombre, new Apagado(), (float) 1.613, fabricante, id);
    }

    public static Dispositivo crearAire2200(String nombre, Fabricante fabricante, Long id){
        return new DispositivoInteligente<>(nombre, new Apagado(), (float) 1.013, fabricante, id);
    }

    public static Dispositivo crearTelevisor21(String nombre, Float horas){
        return new DispositivoEstandar(nombre, (float) 0.075, horas);
    }

    public static Dispositivo crearTelevisor29A34(String nombre, Float horas){
        return new DispositivoEstandar(nombre, (float) 0.175, horas);
    }

    public static Dispositivo crearLCD40(String nombre, Float horas){
        return new DispositivoEstandar(nombre, (float) 0.18, horas);
    }

    public static Dispositivo crearLED24(String nombre, Fabricante fabricante, Long id){
        return new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.04, fabricante, id);
    }

    public static Dispositivo crearLED32(String nombre, Fabricante fabricante, Long id){
        return new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.055, fabricante, id);
    }

    public static Dispositivo crearLED40(String nombre, Fabricante fabricante, Long id){
        return new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.08, fabricante, id);
    }

    public static Dispositivo crearHeladeraConFreezer(String nombre, Fabricante fabricante, Long id){
        return new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.09, fabricante, id);
    }

    public static Dispositivo crearHeladeraSinFreezer(String nombre, Fabricante fabricante, Long id){
        return new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.075, fabricante, id);
    }

    public static Dispositivo crearLavarropasAutomatico5KgAguaCaliente(String nombre, Float horas){
        return new DispositivoEstandar(nombre, (float) 0.875, horas);
    }

    public static Dispositivo crearLavarropasSemiAutomatico5Kg(String nombre, Float horas){
        return new DispositivoEstandar(nombre, (float) 0.1225, horas);
    }

    public static Dispositivo crearLavarropasAutomatico5Kg(String nombre, Fabricante fabricante, Long id){
        return new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.175, fabricante, id);
    }

    public static Dispositivo crearVentiladorTecho(String nombre, Fabricante fabricante, Long id){
        return new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.06, fabricante, id);
    }

    public static Dispositivo crearVentiladorDePie(String nombre, Float horas){
        return new DispositivoEstandar(nombre, (float) 0.09, horas);
    }

    public static Dispositivo crearLamparaHalogena40(String nombre, Fabricante fabricante, Long id){
        return new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.04, fabricante, id);
    }

    public static Dispositivo crearLamparaHalogena60(String nombre, Fabricante fabricante, Long id){
        return new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.06, fabricante, id);
    }

    public static Dispositivo crearLamparaHalogena100(String nombre, Fabricante fabricante, Long id){
        return new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.015, fabricante, id);
    }

    public static Dispositivo crearLampara11W(String nombre, Fabricante fabricante, Long id){
        return new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.011, fabricante, id);
    }

    public static Dispositivo crearLampar15W(String nombre, Fabricante fabricante, Long id){
        return new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.015, fabricante, id);
    }

    public static Dispositivo crearLampara20W(String nombre, Fabricante fabricante, Long id){
        return new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.02, fabricante, id);
    }

    public static Dispositivo crearPCEscritorio(String nombre, Fabricante fabricante, Long id){
        return new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.4, fabricante, id);
    }

    public static Dispositivo crearMicroondas(String nombre, Float horas){
        return new DispositivoEstandar(nombre, (float) 0.64, horas);
    }

    public static Dispositivo crearPlancha(String nombre, Float horas){
        return new DispositivoEstandar(nombre, (float) 0.75, horas);
    }
}
