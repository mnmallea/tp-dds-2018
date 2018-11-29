package controllers;

import dominio.Cliente;
import dominio.dispositivos.Periodo;
import handlebarsUtils.PageUtils;
import handlebarsUtils.PagingViewModel;
import org.hibernate.engine.transaction.synchronization.internal.SynchronizationCallbackCoordinatorNonTrackingImpl;
import reportesUtils.ReporteConsumoPeriodo;
import reportesUtils.Reportes;
import repositorios.RepoClientes;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.HashMap;
import java.util.List;

public class HogaresController {

    public static final int PAGE_SIZE = 10;

    public static ModelAndView show(Request request, Response response) {
        Integer page = PageUtils.getPageRequested(request);

        List<Cliente> clientes = RepoClientes.instancia.getPaginaClientes(page, PAGE_SIZE);
        HashMap<String, Object> model = new HashMap<>();
        model.put("clientes", clientes);
        PagingViewModel pagingViewModel = new PagingViewModel(page, RepoClientes.instancia.cantidadDePaginas(PAGE_SIZE));
        model.put("page", pagingViewModel);
        return new ModelAndView(model, "administrador/hogares.hbs");
    }


    public static ModelAndView seleccionarDispositivos(Request request, Response response) {
        HashMap<String, Object> model = new HashMap<>();

        List<Cliente> clientes = RepoClientes.instancia.getClientes();

        model.put("clientes", clientes);

        return new ModelAndView(model, "administrador/reportes/dispositivos.hbs");
    }

    public static ModelAndView consumosPorPeriodo(Request request, Response response) {
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

        List<ReporteConsumoPeriodo> reportes = Reportes.consumoDeClientesEnPeriodo(new Periodo(inicio, fin), page, PAGE_SIZE);
        HashMap<String, Object> viewModel = new HashMap<>();
        viewModel.put("reportes", reportes);
        PagingViewModel pagingViewModel = new PagingViewModel(page, RepoClientes.instancia.cantidadDePaginas(PAGE_SIZE));
        viewModel.put("page", pagingViewModel);
        viewModel.put("fechaInicio", inicio.truncatedTo(ChronoUnit.MINUTES));
        viewModel.put("fechaFin", fin.truncatedTo(ChronoUnit.MINUTES));

        return new ModelAndView(viewModel, "/administrador/reportes/hogaresPeriodos.hbs");
    }
}
