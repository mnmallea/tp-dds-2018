package dominio;

import java.time.Period;

public interface TipoDispositivo {
	public Boolean estaEncendido();
	public Boolean estaApagado();
	public Float consumoEnHoras(int horas);
	public Float consumoEnPeriodo(Period periodo);
	public void apagarse();
	public void encenderse();
	public void ahorrarEnergia();
	public void setEstado(Estado estado);
}
