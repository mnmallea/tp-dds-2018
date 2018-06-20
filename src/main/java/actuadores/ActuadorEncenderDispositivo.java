package actuadores;
import dominio.DispositivoInteligente;

public class ActuadorEncenderDispositivo implements Actuador{

	@Override
	public void actuaSobre(DispositivoInteligente unDispositivo) {
		unDispositivo.encenderse();
	}
	
}
