package reportesUtils;

import dominio.Cliente;
import dominio.dispositivos.Periodo;

public class ReporteConsumoPeriodo {
    private Double consumo;
    private Cliente cliente;

    private ReporteConsumoPeriodo(Double consumo, Cliente cliente) {
        this.consumo = consumo;
        this.cliente = cliente;
    }

    public Double getConsumo() {
        return consumo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public static ReporteConsumoPeriodo generarReporteDe(Cliente cliente, Periodo periodo){
        Double consumoEnPeriodo = cliente.consumoDeDispositivosInteligentesEnPeriodo(periodo);
        return new ReporteConsumoPeriodo(consumoEnPeriodo, cliente);
    }
}
