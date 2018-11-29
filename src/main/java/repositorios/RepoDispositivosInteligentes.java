package repositorios;

import java.util.List;

import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import dominio.dispositivos.DispositivoInteligente;

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

    
    public List<DispositivoInteligente> dispositivosDeCliente(Integer idCliente){
    	return entityManager().createQuery(" from DispositivoInteligente where cliente =" + idCliente.toString()).getResultList();
    }
}
