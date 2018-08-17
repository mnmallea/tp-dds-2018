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

	public static Dispositivo crearAire3500(String nombre, Fabricante fabricante, Long id) {
		Dispositivo aire = new DispositivoInteligente<>(nombre, new Apagado(), (float) 1.613, fabricante, id);
		setearHoras(aire, HORAS_MINIMAS_AIRE, HORAS_MAXIMAS_AIRE);
		return aire;
	}

	public static Dispositivo crearAire2200(String nombre, Fabricante fabricante, Long id) {
		Dispositivo aire = new DispositivoInteligente<>(nombre, new Apagado(), (float) 1.013, fabricante, id);
		setearHoras(aire, HORAS_MINIMAS_AIRE, HORAS_MAXIMAS_AIRE);
		return aire;
	}

	public static Dispositivo crearTelevisor21(String nombre, Float horas) {
		Dispositivo tele = new DispositivoEstandar(nombre, (float) 0.075, horas);
		setearHoras(tele, HORAS_MINIMAS_TELE, HORAS_MAXIMAS_TELE);
		return tele;
	}

	public static Dispositivo crearTelevisor29A34(String nombre, Float horas) {
		Dispositivo tele = new DispositivoEstandar(nombre, (float) 0.175, horas);
		setearHoras(tele, HORAS_MINIMAS_TELE, HORAS_MAXIMAS_TELE);
		return tele;
	}

	public static Dispositivo crearLCD40(String nombre, Float horas) {
		Dispositivo tele = new DispositivoEstandar(nombre, (float) 0.18, horas);
		setearHoras(tele, HORAS_MINIMAS_TELE, HORAS_MAXIMAS_TELE);
		return tele;
	}

	public static Dispositivo crearLED24(String nombre, Fabricante fabricante, Long id) {
		Dispositivo tele = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.04, fabricante, id);
		setearHoras(tele, HORAS_MINIMAS_TELE, HORAS_MAXIMAS_TELE);
		return tele;
	}

	public static Dispositivo crearLED32(String nombre, Fabricante fabricante, Long id) {
		Dispositivo tele = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.055, fabricante, id);
		setearHoras(tele, HORAS_MINIMAS_TELE, HORAS_MAXIMAS_TELE);
		return tele;
	}

	public static Dispositivo crearLED40(String nombre, Fabricante fabricante, Long id) {
		Dispositivo tele = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.08, fabricante, id);
		setearHoras(tele, HORAS_MINIMAS_TELE, HORAS_MAXIMAS_TELE);
		return tele;
	}

	public static Dispositivo crearHeladeraConFreezer(String nombre, Fabricante fabricante, Long id) {
		return new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.09, fabricante, id);
	}

	public static Dispositivo crearHeladeraSinFreezer(String nombre, Fabricante fabricante, Long id) {
		return new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.075, fabricante, id);
	}

	public static Dispositivo crearLavarropasAutomatico5KgAguaCaliente(String nombre, Float horas) {
		Dispositivo lavarropas = new DispositivoEstandar(nombre, (float) 0.875, horas);
		setearHoras(lavarropas, HORAS_MINIMAS_LAVARROPAS, HORAS_MAXIMAS_LAVARROPAS);
		return lavarropas;
	}

	public static Dispositivo crearLavarropasSemiAutomatico5Kg(String nombre, Float horas) {
		Dispositivo lavarropas = new DispositivoEstandar(nombre, (float) 0.1275, horas);
		setearHoras(lavarropas, HORAS_MINIMAS_LAVARROPAS, HORAS_MAXIMAS_LAVARROPAS);
		return lavarropas;
	}

	public static Dispositivo crearLavarropasAutomatico5Kg(String nombre, Fabricante fabricante, Long id) {
		Dispositivo lavarropas = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.175, fabricante, id);
		setearHoras(lavarropas, HORAS_MINIMAS_LAVARROPAS, HORAS_MAXIMAS_LAVARROPAS);
		return lavarropas;
	}

	public static Dispositivo crearVentiladorTecho(String nombre, Fabricante fabricante, Long id) {
		Dispositivo ventilador = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.06, fabricante, id);
		setearHoras(ventilador, HORAS_MINIMAS_VENTILADOR, HORAS_MAXIMAS_VENTILADOR);
		return ventilador;
	}

	public static Dispositivo crearVentiladorDePie(String nombre, Float horas) {
		Dispositivo ventilador = new DispositivoEstandar(nombre, (float) 0.09, horas);
		setearHoras(ventilador, HORAS_MINIMAS_VENTILADOR, HORAS_MAXIMAS_VENTILADOR);
		return ventilador;
	}

	public static Dispositivo crearLamparaHalogena40(String nombre, Fabricante fabricante, Long id) {
		Dispositivo lampara = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.04, fabricante, id);
		setearHoras(lampara, HORAS_MINIMAS_LAMPARA, HORAS_MAXIMAS_LAMPARA);
		return lampara;
	}

	public static Dispositivo crearLamparaHalogena60(String nombre, Fabricante fabricante, Long id) {
		Dispositivo lampara = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.06, fabricante, id);
		setearHoras(lampara, HORAS_MINIMAS_LAMPARA, HORAS_MAXIMAS_LAMPARA);
		return lampara;
	}

	public static Dispositivo crearLamparaHalogena100(String nombre, Fabricante fabricante, Long id) {
		Dispositivo lampara = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.015, fabricante, id);
		setearHoras(lampara, HORAS_MINIMAS_LAMPARA, HORAS_MAXIMAS_LAMPARA);
		return lampara;
	}

	public static Dispositivo crearLampara11W(String nombre, Fabricante fabricante, Long id) {
		Dispositivo lampara = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.011, fabricante, id);
		setearHoras(lampara, HORAS_MINIMAS_LAMPARA, HORAS_MAXIMAS_LAMPARA);
		return lampara;
	}

	public static Dispositivo crearLampar15W(String nombre, Fabricante fabricante, Long id) {
		Dispositivo lampara = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.015, fabricante, id);
		setearHoras(lampara, HORAS_MINIMAS_LAMPARA, HORAS_MAXIMAS_LAMPARA);
		return lampara;
	}

	public static Dispositivo crearLampara20W(String nombre, Fabricante fabricante, Long id) {
		Dispositivo lampara = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.02, fabricante, id);
		setearHoras(lampara, HORAS_MINIMAS_LAMPARA, HORAS_MAXIMAS_LAMPARA);
		return lampara;
	}

	public static Dispositivo crearPCEscritorio(String nombre, Fabricante fabricante, Long id) {
		Dispositivo pc = new DispositivoInteligente<>(nombre, new Apagado(), (float) 0.4, fabricante, id);
		setearHoras(pc, HORAS_MINIMAS_COMPUTADORA, HORAS_MAXIMAS_COMPUTADORA);
		return pc;
	}

	public static Dispositivo crearMicroondas(String nombre, Float horas) {
		Dispositivo microondas = new DispositivoEstandar(nombre, (float) 0.64, horas);
		setearHoras(microondas, HORAS_MINIMAS_MICROONDAS, HORAS_MAXIMAS_MICROONDAS);
		return microondas;
	}

	public static Dispositivo crearPlancha(String nombre, Float horas) {
		Dispositivo plancha = new DispositivoEstandar(nombre, (float) 0.75, horas);
		setearHoras(plancha, HORAS_MINIMAS_PLANCHA, HORAS_MAXIMAS_PLANCHA);
		return plancha;
	}

	private static void setearHoras(Dispositivo dispositivo, float horasMinimas, float horasMaximas) {
		dispositivo.setHorasMinimas(horasMinimas);
		dispositivo.setHorasMaximas(horasMaximas);
	}

}
