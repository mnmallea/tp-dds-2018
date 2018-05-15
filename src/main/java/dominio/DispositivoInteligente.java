package dominio;

public class DispositivoInteligente {
    private Estado estado;
    private Float consumoPorHora;

    public Float consumoEnHoras(int horas){
        return horas * consumoPorHora;
    }

   /*
   Para mi esto es medio en vano, porque tenemos el consumo en n horas, que seria lo mismo que en un periodo
    public Float consumoEnPeriodo(int empezo, int termino){
    int horas = termino - empezo;
    return this.consumoEnHoras(horas);
    }
    */
   public void apagarse(){
       estado.apagarse();
   }

   public void encenderse(){
       estado.encenderse();
   }

   public void ponerseEnModoAhorroDeEnergia(){
       estado.modoAhorroEnergia();
   }
}
