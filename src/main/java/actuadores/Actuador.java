package actuadores;
import dominio.dispositivos.DispositivoInteligente;

public interface Actuador<T extends DispositivoInteligente<?>> {
	public void actuaSobre(T unDispositivo);
}
