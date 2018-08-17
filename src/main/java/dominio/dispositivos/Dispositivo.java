package dominio.dispositivos;

public interface Dispositivo {
	Float getConsumo();
	Float getHorasMinimas();
	Float getHorasMaximas();
	Float getHorasUsoMes();
	void apagarse();
	void ahorrarEnergia();
	void setHorasMinimas(Float horasMinimas);
	void setHorasMaximas(Float horasMaximas);
}
