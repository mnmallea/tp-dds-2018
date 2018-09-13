package dominio.dispositivos;

import dominio.dispositivos.fabricantes.FabricanteAireAcondicionado;
import dominio.estados.Estado;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "AC")
public class AireAcondicionadoInteligente extends DispositivoInteligente<FabricanteAireAcondicionado> {

    public AireAcondicionadoInteligente(String nombre, Estado estado, Float consumoPorHora,
                                        FabricanteAireAcondicionado fabricante, Long idDeFabrica) {
        super(nombre, estado, consumoPorHora, fabricante, idDeFabrica);
    }

    public AireAcondicionadoInteligente() {
    }

    public void subirTemperatura(Integer unosGrados) {
        fabricante.subirTemperatura(this.idDeFabrica, unosGrados);
    }

    public void bajarTemperatura(Integer unosGrados) {
        fabricante.bajarTemperatura(this.idDeFabrica, unosGrados);
    }

}
