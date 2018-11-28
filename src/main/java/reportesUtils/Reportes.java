package reportesUtils;

import dominio.Cliente;
import dominio.Transformador;
import dominio.Zona;
import dominio.dispositivos.Periodo;
import repositorios.RepoClientes;
import repositorios.RepoTransformadores;
import repositorios.RepoZonas;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Reportes {


    public static List<ReporteTransformador> comsumoTransformadoresEnPeriodo(LocalDateTime inicio, LocalDateTime fin, int page, int pageSize) {
        List<Transformador> transformadores = RepoTransformadores.instancia.getPaginaTransformadores(page, pageSize);

        List<ReporteTransformador> reportes = getReporteTransformadores(inicio, fin, transformadores);

        return reportes;
    }

    private static List<ReporteTransformador> getReporteTransformadores(LocalDateTime inicio, LocalDateTime fin, List<Transformador> transformadores) {
        return transformadores.stream().map(t -> new ReporteTransformador(t, t.consumoPromedioEnPeriodo(inicio, fin))).collect(Collectors.toList());
    }

    public static List<ReporteTransformador> comsumoTransformadoresPorZonaEnPeriodo(LocalDateTime inicio, LocalDateTime fin, int page, int pageSize, Long idZona) {
        Zona zona = RepoZonas.instance.getZonaPorID(idZona);
        List<Transformador> transformadores = zona.getTransformadores();
        int fromIndex = (page - 1) * pageSize;
        return getReporteTransformadores(inicio, fin, transformadores.subList(fromIndex, Math.min(fromIndex + pageSize, transformadores.size())));
    }

    public static List<ReporteConsumoPeriodo> consumoDeClientesEnPeriodo(Periodo periodo, int page, int pageSize) {
        List<Cliente> clientes = RepoClientes.instancia.getPaginaClientes(page, pageSize);
        return clientes.stream().map(cliente -> ReporteConsumoPeriodo.generarReporteDe(cliente, periodo)).collect(Collectors.toList());
    }
}
