package dominio.dispositivos;

import dominio.dispositivos.fabricantes.FabricanteReflector;
import dominio.estados.Estado;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "RI")
public class ReflectorInteligente extends DispositivoInteligente<FabricanteReflector> {

    public ReflectorInteligente(String nombre, Estado estado, Float consumoPorHora, FabricanteReflector fabricante,
                                Long idDeFabrica) {
        super(nombre, estado, consumoPorHora, fabricante, idDeFabrica);

    }

    public ReflectorInteligente() {
    }

    public void aumentarIntensidad(Double unosLux) {
        fabricante.aumentarIntensidad(idDeFabrica, unosLux);
    }

    public void disminuirIntensidad(Double unosLux) {
        fabricante.disminuirIntensidad(idDeFabrica, unosLux);
    }

}
