package actuadores;
import dominio.DispositivoInteligente;

public class ActuadorEncenderDispositivo implements Actuador<DispositivoInteligente>{

	@Override
	public void actuaSobre(DispositivoInteligente unDispositivo) {
		unDispositivo.encenderse();
	}
	
}
