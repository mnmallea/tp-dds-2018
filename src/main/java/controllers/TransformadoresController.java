package controllers;

import dominio.Zona;
import handlebarsUtils.PageUtils;
import handlebarsUtils.PagingViewModel;
import reportesUtils.ReporteTransformador;
import reportesUtils.Reportes;
import repositorios.RepoTransformadores;
import repositorios.RepoZonas;
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
        String endTime = request.queryParams("end-time");
        String startTime = request.queryParams("start-time");
        LocalDateTime fin;
        LocalDateTime inicio;
        try {
            fin = LocalDateTime.parse(endTime);
            inicio = LocalDateTime.parse(startTime);
        } catch (Exception ex) {
            fin = LocalDateTime.now();
            inicio = fin.minusMonths(1);
        }
        HashMap<String, Object> viewModel = new HashMap<>();

        Long idZona;
        try {
            idZona = Long.valueOf(request.queryParams("zona"));
        } catch (Exception e) {
            idZona = null;
        }

        viewModel.put("zonaSeleccionada", idZona);

        List<ReporteTransformador> reportes;
        if (idZona == null)
            reportes = Reportes.comsumoTransformadoresEnPeriodo(inicio, fin, page, PAGE_SIZE);
        else
            reportes = Reportes.comsumoTransformadoresPorZonaEnPeriodo(inicio, fin, page, PAGE_SIZE, idZona);
        viewModel.put("reportes", reportes);

        List<Zona> zonas = RepoZonas.instance.getZonas();
        viewModel.put("zonas", zonas);


        PagingViewModel pagingViewModel = new PagingViewModel(page, RepoTransformadores.instancia.cantidadDePaginas(5));
        viewModel.put("page", pagingViewModel);
        return new ModelAndView(viewModel, "reportes/transformadores.hbs");
    }
}
