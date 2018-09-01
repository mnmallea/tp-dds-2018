package dominio.dispositivos;

public interface Dispositivo {
    Float getConsumo();

    Float getHorasMinimas();

    void setHorasMinimas(Float horasMinimas);

    Float getHorasMaximas();

    void setHorasMaximas(Float horasMaximas);

    Float getHorasUsoMes();

    void apagarse();

    void ahorrarEnergia();
}
