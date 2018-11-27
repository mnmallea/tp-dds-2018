package controllers;

import dominio.Cliente;
import handlebarsUtils.PageUtils;
import handlebarsUtils.PagingViewModel;
import repositorios.RepoClientes;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;

public class HogaresController {
    public static ModelAndView show(Request request, Response response) {
        Integer page = PageUtils.getPageRequested(request);

        List<Cliente> clientes = RepoClientes.instancia.getPaginaClientes(page);
        HashMap<String, Object> model = new HashMap<>();
        model.put("clientes", clientes);
        PagingViewModel pagingViewModel = new PagingViewModel(page, RepoClientes.instancia.cantidadDePaginas());
        model.put("page", pagingViewModel);
        return new ModelAndView(model, "administrador/reportes/hogares.hbs");
    }


    public static ModelAndView seleccionarDispositivos(Request request, Response response) {
        HashMap<String, Object> model = new HashMap<>();

        List<Cliente> clientes = RepoClientes.instancia.getClientes();

        model.put("clientes", clientes);

        return new ModelAndView(model, "administrador/reportes/dispositivos.hbs");
    }
}
