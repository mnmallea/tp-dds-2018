package simplex;

import dominio.dispositivos.Dispositivo;

public enum EfectoSimplex {
    APAGAR{
    	public void aplicarseA(Dispositivo dispositivo) {
            dispositivo.apagarse();
        }
    },
    NO_HACER_NADA{
    	public void aplicarseA(Dispositivo dispositivo) {
    		
        }
    },
    AHORRAR_ENERGIA{
    	public void aplicarseA(Dispositivo dispositivo) {
            dispositivo.ahorrarEnergia();
        }
    };

	public abstract void aplicarseA(Dispositivo dispositivo) ;
}