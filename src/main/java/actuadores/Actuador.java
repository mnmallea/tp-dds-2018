package actuadores;

import dominio.dispositivos.DispositivoInteligente;

public interface Actuador<T extends DispositivoInteligente<?>> {
    void actuaSobre(T unDispositivo);
}
