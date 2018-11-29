package dominio.dispositivos.fabricantes;

import javax.persistence.Entity;

@Entity
public abstract class FabricanteAireAcondicionado extends Fabricante {

    public abstract void subirTemperatura(Long idDeFabrica, Integer unosGrados);

    public abstract void bajarTemperatura(Long idDeFabrica, Integer unosGrados);
}
