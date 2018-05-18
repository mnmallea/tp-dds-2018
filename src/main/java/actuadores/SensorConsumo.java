package actuadores;

import dominio.DispositivoInteligente;

public class SensorConsumo implements Sensor{

	@Override
	public Medicion realizarMedicion(DispositivoInteligente unDispositivo) {
		return new MedicionConsumo(unDispositivo, unDispositivo.getConsumoPorHora());
	}

	@Override
	public void comunicarMedicion() {
		// TODO Auto-generated method stub
		
	}
}
