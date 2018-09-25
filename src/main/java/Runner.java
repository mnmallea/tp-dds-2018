import dominio.dispositivos.DispositivoInteligente;
import dominio.dispositivos.FabricaDeDispositivos;
import dominio.dispositivos.fabricantes.Fabricante;
import org.mockito.Mockito;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        DispositivoInteligente dispositivoInteligente = FabricaDeDispositivos.crearLED40("Blah", Mockito.mock(Fabricante.class), 1L);

//        dispositivoInteligente.encenderse();
//        Thread.sleep(1000);
//        dispositivoInteligente.apagarse();
//
//        dispositivoInteligente.encenderse();
//        Thread.sleep(1000);
//        dispositivoInteligente.apagarse();
//
//        dispositivoInteligente.encenderse();
//        Thread.sleep(1000);
//        dispositivoInteligente.apagarse();
//
//        entityTransaction.begin();
//        entityManager.persist(dispositivoInteligente);
//        entityTransaction.commit();

        DispositivoInteligente dispositivoInteligente1 = entityManager.find(DispositivoInteligente.class, 1L);
        dispositivoInteligente1.getPeriodosEncendido().forEach(System.out::println);
        System.out.println(dispositivoInteligente1.getEstado());
        System.out.println(dispositivoInteligente.getEstado());
    }
}
