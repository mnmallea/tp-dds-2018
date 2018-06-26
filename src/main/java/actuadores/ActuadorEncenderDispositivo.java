package actuadores;
import dominio.DispositivoInteligente;
import dominio.Fabricante;

public class ActuadorEncenderDispositivo implements Actuador<DispositivoInteligente<? extends Fabricante>>{

	@Override
	public void actuaSobre(DispositivoInteligente unDispositivo) {
		unDispositivo.encenderse();
	}
	
}
