package dominio.dispositivos.fabricantes;

public interface FabricanteAireAcondicionado extends Fabricante {

    void subirTemperatura(Long idDeFabrica, Integer unosGrados);

    void bajarTemperatura(Long idDeFabrica, Integer unosGrados);
}
