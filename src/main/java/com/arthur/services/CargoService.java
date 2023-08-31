
package com.arthur.services;

import arthur.generico.Service;
import com.arthur.modelo.Cargo;
import java.util.*;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author Arthur
 */
@Stateless
public class CargoService extends Service<Cargo>{

    public CargoService() {
        super(Cargo.class);
    }
    
    public List<Cargo> findByAll(Cargo cargo){
        
        String sql = "select c from Cargo c where ";
        if(cargo.getNome() != null && !cargo.getNome().equals("")){
            sql += "lower(c.nome) like lower(:nome) and ";
        }
        
        sql +="c.ativo = true ";
        
        Query query = getEm().createQuery(sql, Cargo.class);
        
        if(cargo.getNome() != null && !cargo.getNome().equals("")){
            query.setParameter("nome", "%"+cargo.getNome()+"%");
        }
        
        return query.getResultList();
    }
    
    
    public List<Cargo> findCargoAutoComplete(String nome) {
        String sql = "select e from Cargo e where e.ativo=true ";

        if (nome != null && !nome.equals("")) {
            sql += " and lower (e.nome) like lower(:nome) ";
        }
        Query query = getEm().createQuery(sql, Cargo.class);

        if (nome != null && !nome.equals("")) {
            query.setParameter("nome", "%" + nome.replaceAll(" ", "%") + "%");
        }
        return query.getResultList();
    }
    
    public void desativar(Cargo cargo){
        cargo.setAtivo(false);
        getEm().merge(cargo);
    }
}
