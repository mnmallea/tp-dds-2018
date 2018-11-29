package repositorios;

import dominio.dispositivos.DispositivoEstandar;
import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public class RepoDispositivosEstandares implements WithGlobalEntityManager, EntityManagerOps {
    public static final RepoDispositivosEstandares instancia = new RepoDispositivosEstandares();

    private RepoDispositivosEstandares() {
    }

    public void agregarDispositivoEstandar(DispositivoEstandar dispositivo){
        entityManager().persist(dispositivo);
    }

    public DispositivoEstandar buscarPorId(Long id){
        return entityManager().find(DispositivoEstandar.class, id);
    }
}
