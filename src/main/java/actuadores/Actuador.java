package actuadores;

public abstract class Actuador {
	private Long identificadorDeFabricaDI;
	
	public abstract void recibirAccion();
	public abstract void generarAccion();
}
