package actuadores;

import java.util.List;

import dominio.DispositivoInteligente;

public class ReglaParaMovimiento implements ReglaParaMovimientoFabricante {
    private DispositivoInteligente dispositivo;
    private List<Actuador> actuadores;


    public ReglaParaMovimiento(DispositivoInteligente dispositivo, List<Actuador> actuadores) {
        this.dispositivo = dispositivo;
        this.actuadores = actuadores;
    }


    @Override
    @SuppressWarnings("unchecked")
    public void huboMovimiento() {
        actuadores.forEach(actuador -> actuador.actuaSobre(dispositivo));
    }
}
