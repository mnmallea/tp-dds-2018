package repositorios;

import dominio.Transformador;

import java.util.ArrayList;
import java.util.List;

public class RepoTransformadores {
    public static final RepoTransformadores instancia = new RepoTransformadores();
    private List<Transformador> transformadores = new ArrayList<>();

    private RepoTransformadores() {
    }

    public List<Transformador> getTransformadores() {
        return transformadores;
    }

    public void setTransformadores(List<Transformador> transformadores) {
        this.transformadores = transformadores;
    }

    public void agregarTransformador(Transformador unTransformador) {
        transformadores.add(unTransformador);
    }

    public void limpiarTransformadores() {
        transformadores = new ArrayList<>();
    }


}