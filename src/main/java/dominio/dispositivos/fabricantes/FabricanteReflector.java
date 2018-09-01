package dominio.dispositivos.fabricantes;

public interface FabricanteReflector extends Fabricante {
	
	void aumentarIntensidad(Long idDeFabrica, Double unosLux);
	
	void disminuirIntensidad(Long idDeFabrica, Double unosLux);
}
