package controllers;

import dominio.Cliente;
import dominio.dispositivos.DispositivoInteligente;
import dominio.dispositivos.PeriodoEncendido;
import spark.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

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

    public static ModelAndView consumos(Cliente cliente){

    }
}
