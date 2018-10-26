package dominio.dispositivos;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class DispositivoEstandar extends Dispositivo {

    @GeneratedValue
    @Id
    private Long id;
    private String nombre;
    private Float consumoPorHora;
    private Float horasDeUsoDiarias;
    private Long numeroDeSerie;
    private Float horasMinimas;
    private Float horasMaximas;

    public DispositivoEstandar(String nombre, Float consumoPorHora, Float horasDeUsoDiarias) {
        this.nombre = nombre;
        this.consumoPorHora = consumoPorHora;
        this.horasDeUsoDiarias = horasDeUsoDiarias;
    }

    public DispositivoEstandar() {
    }

    public Float getConsumoPorHora() {
        return this.consumoPorHora;
    }

    public Float consumoTotal() {
        return this.consumoPorHora * this.horasDeUsoDiarias * 30;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public Float getHorasMinimas() {
        return horasMinimas;
    }

    public void setHorasMinimas(Float horasMinimas) {
        this.horasMinimas = horasMinimas;
    }

    public Float getHorasMaximas() {
        return horasMaximas;
    }

    public void setHorasMaximas(Float horasMaximas) {
        this.horasMaximas = horasMaximas;
    }

    @Override
    public Float getHorasUsoMes() {
        return this.horasDeUsoDiarias * 30;
    }

    public void ahorrarEnergia() {

    }

    public void apagarse() {

    }
}
