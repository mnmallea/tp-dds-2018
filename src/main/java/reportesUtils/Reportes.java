package reportesUtils;

import dominio.Transformador;
import repositorios.RepoTransformadores;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Reportes {


    public static List<ReporteTransformador> comsumoTransformadoresEnPeriodo(LocalDateTime inicio, LocalDateTime fin, int page, int pageSize) {
        List<Transformador> transformadores = RepoTransformadores.instancia.getPaginaTransformadores(page, pageSize);

        List<ReporteTransformador> reportes = transformadores.stream().map(t -> new ReporteTransformador(t, t.consumoPromedioEnPeriodo(inicio, fin))).collect(Collectors.toList());

        reportes.add(new ReporteTransformador(transformadores.get(0), 1254.054));
        return reportes;
    }
}
