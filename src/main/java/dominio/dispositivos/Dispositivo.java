package dominio.dispositivos;

public interface Dispositivo {
	Float getConsumo();
	Float getHorasMinimas();
	Float getHorasMaximas();
	Float getHorasUsoMes();
	void apagarse();
	void ahorrarEnergia();
}
