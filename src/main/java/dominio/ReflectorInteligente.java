package dominio;

public class ReflectorInteligente extends DispositivoInteligente{
	private FabricanteReflector fabricante;
	
	public ReflectorInteligente(String nombre, Estado estado, Float consumoPorHora, FabricanteReflector fabricante,
			Long idDeFabrica) {
		super(nombre, estado, consumoPorHora, fabricante, idDeFabrica);
		this.fabricante = fabricante;
		
	}
	
	public void aumentarIntensidad(Double unosLux) {
		fabricante.aumentarIntensidad(idDeFabrica, unosLux);
	}
	
	public void disminuirIntensidad(Double unosLux) {
		fabricante.disminuirIntensidad(idDeFabrica, unosLux);
	}

}
