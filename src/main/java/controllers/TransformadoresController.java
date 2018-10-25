package controllers;

import handlebarsUtils.PageUtils;
import handlebarsUtils.PagingViewModel;
import reportesUtils.ReporteTransformador;
import reportesUtils.Reportes;
import repositorios.RepoTransformadores;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class TransformadoresController {

    private static final int PAGE_SIZE = 5;

    public static ModelAndView show(Request request, Response response) {
        Integer page = PageUtils.getPageRequested(request);
        LocalDateTime fin = LocalDateTime.now();
        LocalDateTime inicio = fin.minusMonths(1);
        List<ReporteTransformador> reportes = Reportes.comsumoTransformadoresEnPeriodo(inicio, fin, page, PAGE_SIZE);
        HashMap<String, Object> viewModel = new HashMap<>();
        viewModel.put("reportes", reportes);
        PagingViewModel pagingViewModel = new PagingViewModel(page, RepoTransformadores.instancia.cantidadDePaginas(5));
        viewModel.put("page", pagingViewModel);
        return new ModelAndView(viewModel, "reportes/transformadores.hbs");
    }
}
