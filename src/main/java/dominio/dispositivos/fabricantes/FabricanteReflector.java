package dominio.dispositivos.fabricantes;

import javax.persistence.Entity;

@Entity
public abstract class FabricanteReflector extends Fabricante {
	
	public abstract void aumentarIntensidad(Long idDeFabrica, Double unosLux);
	
	public abstract void disminuirIntensidad(Long idDeFabrica, Double unosLux);
}
