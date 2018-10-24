package controllers;

import dominio.Cliente;
import handlebarsUtils.PagingViewModel;
import repositorios.RepoClientes;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;

public class HogaresController {
    public static ModelAndView show(Request request, Response response) {
        Integer page = null;
        try {
            page = Math.max(Integer.valueOf(request.queryParams("page")), 1);
        } catch (NumberFormatException e) {
            page = 1;
        }

        List<Cliente> clientes = RepoClientes.instancia.getPaginaClientes(page);
        HashMap model = new HashMap();
        model.put("clientes", clientes);
        PagingViewModel pagingViewModel = new PagingViewModel(page, RepoClientes.instancia.cantidadDePaginas());
        model.put("page", pagingViewModel);
        return new ModelAndView(model, "reportes/hogares.hbs");
    }
}
