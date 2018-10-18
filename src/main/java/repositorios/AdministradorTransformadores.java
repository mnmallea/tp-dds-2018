package repositorios;

import java.util.List;
import java.util.stream.Collectors;

import dominio.Transformador;
import dominio.Zona;

public class AdministradorTransformadores {

    public static final AdministradorTransformadores instancia = new AdministradorTransformadores();


    private AdministradorTransformadores() {
    }

    public void agregarTransformador(Transformador transformador) {
        RepoTransformadores.instancia.agregarTransformador(transformador);
    }

    public List<Transformador> getTransformadores() {
        return RepoTransformadores.instancia.getTransformadores();
    }

    public List<Transformador> inicializarTransformadores(Zona zona) {
        List<Transformador> transformadores = this.getTransformadores();

        return transformadores.stream().filter(transformador -> zona.estaDentroDeZona(transformador.getCoordenadas()))
        		.collect(Collectors.toList());
    }
}
