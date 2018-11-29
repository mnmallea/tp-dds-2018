package controllers;

import dominio.Cliente;
import dominio.dispositivos.DispositivoInteligente;
import dominio.dispositivos.Periodo;
import spark.ModelAndView;
import spark.Request;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class ClienteController {
    public static ModelAndView home(Cliente cliente) {

        HashMap model = new HashMap();
        List<DispositivoInteligente> dispositivos = cliente.getDispositivosInteligentes();
        Double ultimoConsumo = cliente.consumoDeDispositivosInteligentesEnPeriodo(new Periodo(LocalDateTime.of(2018, 10, 01, 0, 0), LocalDateTime.now()));
        dispositivos.forEach(d -> d.getEstado().toString());
        model.put("dispositivos", dispositivos);
        model.put("ultimoConsumo", ultimoConsumo);
        return new ModelAndView(model, "cliente/hogar.hbs");
    }

    public static ModelAndView consumos(Request req, Cliente cliente) {
        String endTime = req.queryParams("end-time");
        String startTime = req.queryParams("start-time");
        LocalDateTime fin;
        LocalDateTime inicio;
        try {
            fin = LocalDateTime.parse(endTime);
            inicio = LocalDateTime.parse(startTime);
        } catch (Exception ex) {
            fin = LocalDateTime.now();
            inicio = fin.minusMonths(1);
        }

        Double ultimoConsumo = cliente.consumoDeDispositivosInteligentesEnPeriodo(inicio, fin);

        HashMap model = new HashMap();
        model.put("ultimoConsumo", ultimoConsumo);

        return new ModelAndView(model, "cliente/consumos.hbs");
    }
}
