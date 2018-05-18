package actuadores;

import dominio.Dispositivo;

public class SensorConsumo implements Sensor{

	@Override
	public Medicion realizarMedicion(Dispositivo unDispositivo) {
		return new MedicionConsumo(unDispositivo, unDispositivo.getConsumoPorHora());
	}

	@Override
	public void comunicarMedicion() {
		// TODO Auto-generated method stub
		
	}
}
