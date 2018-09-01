package simplex;

import dominio.dispositivos.Dispositivo;

public class ApagarSimplex implements EfectoSimplex {

    @Override
    public void aplicarseA(Dispositivo dispositivo) {
        dispositivo.apagarse();
    }

}
