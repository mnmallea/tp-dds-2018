package dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DispositivoDto implements Serializable {

    private Boolean encendido;
    private String nombre;
    @SerializedName("consumo_por_hora")
    private Float consumoPorHora;

    public Boolean getEncendido() {
        return encendido;
    }

    public void setEncendido(Boolean encendido) {
        this.encendido = encendido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getConsumoPorHora() {
        return consumoPorHora;
    }

    public void setConsumoPorHora(Float consumoPorHora) {
        this.consumoPorHora = consumoPorHora;
    }
}
