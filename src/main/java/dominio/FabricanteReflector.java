package dominio;

public interface FabricanteReflector extends Fabricante {
	
	public void aumentarIntensidad(Long idDeFabrica, Double unosLux);
	
	public void disminuirIntensidad(Long idDeFabrica, Double unosLux);
}
