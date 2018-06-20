package actuadores;

import dominio.DispositivoInteligente;

public class ReglaParaMovimiento implements ReglaParaMovimientoFabricante{
	DispositivoInteligente dispositivo;
	
	
	@Override
	public void huboMovimiento() {
		dispositivo.encenderse();
		
	}

}
