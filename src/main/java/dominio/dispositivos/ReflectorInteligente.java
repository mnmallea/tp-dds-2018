package dominio.dispositivos;

import dominio.dispositivos.fabricantes.FabricanteReflector;
import dominio.estados.Estado;

public class ReflectorInteligente extends DispositivoInteligente<FabricanteReflector> {

    public ReflectorInteligente(String nombre, Estado estado, Float consumoPorHora, FabricanteReflector fabricante,
                                Long idDeFabrica) {
        super(nombre, estado, consumoPorHora, fabricante, idDeFabrica);

    }

    public void aumentarIntensidad(Double unosLux) {
        fabricante.aumentarIntensidad(idDeFabrica, unosLux);
    }

    public void disminuirIntensidad(Double unosLux) {
        fabricante.disminuirIntensidad(idDeFabrica, unosLux);
    }

}
