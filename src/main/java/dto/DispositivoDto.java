package dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DispositivoDto implements Serializable {

    private Boolean encendido;
    private String nombre;
    @SerializedName("consumo_por_hora")
    private Double consumoPorHora;

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

    public Double getConsumoPorHora() {
        return consumoPorHora;
    }

    public void setConsumoPorHora(Double consumoPorHora) {
        this.consumoPorHora = consumoPorHora;
    }
}
