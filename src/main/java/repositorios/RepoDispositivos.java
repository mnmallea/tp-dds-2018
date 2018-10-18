package repositorios;

import dominio.dispositivos.DispositivoInteligente;
import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

public class RepoDispositivos implements WithGlobalEntityManager, EntityManagerOps {
    public static final RepoDispositivos instancia = new RepoDispositivos();

    private RepoDispositivos() {
    }

    public void agregarDispositivoInteligente(DispositivoInteligente dispositivo){
        entityManager().persist(dispositivo);
    }

    public DispositivoInteligente buscarPorId(Long id){
        return entityManager().find(DispositivoInteligente.class, id);
    }
}
