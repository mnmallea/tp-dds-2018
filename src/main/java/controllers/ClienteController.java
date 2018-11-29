package controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import dominio.Cliente;
import dominio.dispositivos.Dispositivo;
import dominio.dispositivos.DispositivoInteligente;
import dominio.dispositivos.PeriodoEncendido;
import simplex.OptimizadorHoras;
import simplex.SolucionSimplex;
import spark.ModelAndView;

public class ClienteController {
    public static ModelAndView home(Cliente cliente){

        HashMap model = new HashMap();
        List<DispositivoInteligente> dispositivos = cliente.getDispositivosInteligentes();
        Double ultimoConsumo = cliente.consumoDeDispositivosInteligentesEnPeriodo(new PeriodoEncendido(LocalDateTime.of(2018, 10, 01, 0, 0), LocalDateTime.now()));
        dispositivos.forEach(d-> d.getEstado().toString());
        model.put("dispositivos", dispositivos);
        model.put("ultimoConsumo", ultimoConsumo);
        return new ModelAndView(model, "cliente/hogar.hbs");
    }

//    public static ModelAndView consumos(Cliente cliente){
//
//    }
    
    public static ModelAndView simplex(Cliente cliente){
    	HashMap model = new HashMap();
    	List<Dispositivo> dispositivos = cliente.getDispositivos();
    	OptimizadorHoras optimizador = new OptimizadorHoras();
    	List<SolucionSimplex> solucionesSimplex = optimizador.optimizarHorasUso(dispositivos);
    	String persona = cliente.getNombre();
    	model.put("persona", persona);
    	model.put("dispositivos", dispositivos);
    	model.put("solucionesSimplex", solucionesSimplex);
    	return new ModelAndView(model, "cliente/simplex.hbs");
    }
}
