package dominio.dispositivos.fabricantes;

public interface FabricanteAireAcondicionado extends Fabricante {

	public void subirTemperatura(Long idDeFabrica, Integer unosGrados);

	public void bajarTemperatura(Long idDeFabrica, Integer unosGrados);
}
