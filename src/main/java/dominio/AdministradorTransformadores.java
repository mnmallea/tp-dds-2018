package dominio;

import repositorios.RepoTransformadores;

import java.util.ArrayList;
import java.util.List;

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

}
