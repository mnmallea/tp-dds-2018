package dominio.dispositivos;

public abstract class Dispositivo {

	public abstract Float consumoTotal();

	public abstract Float getHorasMinimas();

	public abstract void setHorasMinimas(Float horasMinimas);

	public abstract Float getHorasMaximas();

	public abstract void setHorasMaximas(Float horasMaximas);

	public abstract Float getHorasUsoMes();

	public abstract void apagarse();

	public abstract void ahorrarEnergia();
}
