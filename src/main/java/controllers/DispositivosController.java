package controllers;

import dominio.Cliente;
import dominio.dispositivos.DispositivoInteligente;
import reportesUtils.ConsumoPromedio;
import repositorios.RepoClientes;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DispositivosController {
    public static ModelAndView showConsumos(Request request, Response response) {
        Long id = Long.valueOf(request.params("id"));
        Cliente cliente = RepoClientes.instancia.buscarClientePorId(id);
        HashMap<String, Object> viewModel = new HashMap<>();
        List<DispositivoInteligente> dispositivos = cliente.getDispositivosInteligentes();
        List<ConsumoPromedio> consumos = dispositivos.stream().map(ConsumoPromedio::new).collect(Collectors.toList());
        viewModel.put("consumos", consumos);
        boolean hayDispositivos = !dispositivos.isEmpty();
        viewModel.put("hayDispositivos", hayDispositivos);
        return new ModelAndView(viewModel, "administrador/reportes/reporteDispositivos.hbs");
    }
}
