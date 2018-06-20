package dominio;

public class AireAcondicionadoInteligente extends DispositivoInteligente{

	private FabricanteAireAcondicionado fabricante;
	
	public AireAcondicionadoInteligente(String nombre, Estado estado, Float consumoPorHora, FabricanteAireAcondicionado fabricante,
			Long idDeFabrica) {
		super(nombre, estado, consumoPorHora, fabricante, idDeFabrica);
		this.fabricante = fabricante;
	}
	
	public void subirTemperatura(Integer unosGrados) {
		fabricante.subirTemperatura(this.idDeFabrica, unosGrados);
	}
	
	public void bajarTemperatura(Integer unosGrados) {
		fabricante.bajarTemperatura(this.idDeFabrica, unosGrados);
	}
	
}
