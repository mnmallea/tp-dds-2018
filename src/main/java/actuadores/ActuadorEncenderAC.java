package actuadores;
import dominio.DispositivoInteligente;

public class ActuadorEncenderAC implements Actuador{

	@Override
	public void actuaSobre(DispositivoInteligente unDispositivo) {
		unDispositivo.encenderse();
	}
	
}
