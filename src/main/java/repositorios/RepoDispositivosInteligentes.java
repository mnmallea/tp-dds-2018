package repositorios;

import dominio.dispositivos.DispositivoInteligente;
import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import java.util.List;

public class RepoDispositivosInteligentes implements WithGlobalEntityManager, EntityManagerOps {
    public static final RepoDispositivosInteligentes instancia = new RepoDispositivosInteligentes();

    private RepoDispositivosInteligentes() {
    }
    
    public void agregarDispositivosInteligentes(List<DispositivoInteligente> dispositivos){
        dispositivos.forEach(this::agregarDispositivoInteligente);
    }

    public void agregarDispositivoInteligente(DispositivoInteligente dispositivo){
        entityManager().persist(dispositivo);
    }

    public DispositivoInteligente buscarPorId(Long id){
        return entityManager().find(DispositivoInteligente.class, id);
    }
}
