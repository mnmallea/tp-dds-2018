package dominio;

import repositorios.RepoTransformadores;

import java.util.ArrayList;
import java.util.List;

public class AdministradorTransformadores {

    private List<Transformador> transformadores = new ArrayList<Transformador>();

    public void agregarCliente(Transformador transformador) {
        RepoTransformadores.instancia.agregarTransformador(transformador);
    }

    public List<Transformador> getClientes() {
        return RepoTransformadores.instancia.getTransformadores();
    }

}
