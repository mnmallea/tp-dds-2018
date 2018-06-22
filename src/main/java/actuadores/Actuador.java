package actuadores;
import dominio.DispositivoInteligente;

public interface Actuador<T extends DispositivoInteligente<?>> {
	public void actuaSobre(T unDispositivo);
}
