package arthur.generico;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Arthur
 */
public class Service<T> {

    @PersistenceContext
    EntityManager em;
    private Class<T> entidade;

    public Service() {
    }

    public Service(Class<T> entidade) {
        this.entidade = entidade;
    }
    
    public void salvar(T entidade){
        em.persist(entidade);
    }
    
    public void atualizar(T entidade){
        em.merge(entidade);
    }
    
    public void remover(T entidade){
    }
    
    public T find(Long id){
        T objeto = getEm().find(entidade, id);
        getEm().refresh(objeto);
        return objeto;
    }
    
    public List<T> findAll(){
        return em.createQuery("SELECT t FROM " + entidade.getSimpleName() + " t WHERE t.ativo = true").getResultList();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
   

}
