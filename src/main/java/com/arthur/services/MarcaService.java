
package com.arthur.services;

import arthur.generico.Service;
import com.arthur.modelo.Marca;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Arthur
 */
@Stateless
public class MarcaService extends Service<Marca>{
    
    public MarcaService(){
        super(Marca.class);
    }
    
    public List<Marca> findByAll(Marca marca){
        
        String sql = "select m from Marca m where ";
        if(marca.getNome() != null && !marca.getNome().equals("")){
            sql += "lower(m.nome) like lower(:nome) and ";
        }
        
        sql +="m.ativo = true ";
        
        Query query = getEm().createQuery(sql, Marca.class);
        
        if(marca.getNome() != null && !marca.getNome().equals("")){
            query.setParameter("nome", "%"+marca.getNome()+"%");
        }
        
        return query.getResultList();
    }
    
    
    public List<Marca> findMarcaAutoComplete(String nome) {
        String sql = "select e from Marca e where e.ativo=true ";

        if (nome != null && !nome.equals("")) {
            sql += " and lower (e.nome) like lower(:nome) ";
        }
        Query query = getEm().createQuery(sql, Marca.class);

        if (nome != null && !nome.equals("")) {
            query.setParameter("nome", "%" + nome.replaceAll(" ", "%") + "%");
        }
        return query.getResultList();
    }
    
    public void desativar(Marca marca){
        marca.setAtivo(false);
        getEm().merge(marca);
    }

}
