package repositorios;

import dominio.Transformador;
import dominio.Zona;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdministradorTransformadores {

    public static final AdministradorTransformadores instancia = new AdministradorTransformadores();
    private List<Transformador> transformadores = new ArrayList<>();

    private AdministradorTransformadores() {
    }

    public void agregarCliente(Transformador transformador) {
        RepoTransformadores.instancia.agregarTransformador(transformador);
    }

    public List<Transformador> getTransformadores() {
        return RepoTransformadores.instancia.getTransformadores();
    }

    public List<Transformador> inicializarTransformadores(Zona zona) {
        List<Transformador> transformadores = this.getTransformadores();
        return transformadores.stream().filter(transformador -> transformador.getZona().equals(zona)).collect(Collectors.toList());
    }
}
