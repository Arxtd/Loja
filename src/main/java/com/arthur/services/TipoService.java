
package com.arthur.services;

import arthur.generico.Service;
import com.arthur.modelo.Tipo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author Arthur
 */
@Stateless
public class TipoService extends Service<Tipo>{

    public TipoService() {
        super(Tipo.class);
    }
    
    public List<Tipo> findByAll(Tipo tipo){
        
        String sql = "select t from Tipo t where ";
        if(tipo.getNome() != null && !tipo.getNome().equals("")){
            sql += "lower(t.nome) like lower(:nome) and ";
        }
        
        sql +="t.ativo = true ";
        
        Query query = getEm().createQuery(sql, Tipo.class);
        
        if(tipo.getNome() != null && !tipo.getNome().equals("")){
            query.setParameter("nome", "%"+tipo.getNome()+"%");
        }
        
        return query.getResultList();
    }
    
    
    public List<Tipo> findTipoAutoComplete(String nome) {
        String sql = "select e from Tipo e where e.ativo=true ";

        if (nome != null && !nome.equals("")) {
            sql += " and lower (e.nome) like lower(:nome) ";
        }
        Query query = getEm().createQuery(sql, Tipo.class);

        if (nome != null && !nome.equals("")) {
            query.setParameter("nome", "%" + nome.replaceAll(" ", "%") + "%");
        }
        return query.getResultList();
    }
    
    public void desativar(Tipo tipo){
        tipo.setAtivo(false);
        getEm().merge(tipo);
    }
}
