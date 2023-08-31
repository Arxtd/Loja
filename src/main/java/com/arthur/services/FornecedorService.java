package com.arthur.services;

import arthur.generico.Service;
import com.arthur.modelo.Fornecedor;
import java.util.*;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author Arthur
 */

@Stateless
public class FornecedorService extends Service<Fornecedor>{
    
    public FornecedorService(){
        super(Fornecedor.class);
    }
    
    public List<Fornecedor> findByAll(Fornecedor fornecedor){
        
        String sql = "select f from Fornecedor f where ";
        if(fornecedor.getNome() != null && !fornecedor.getNome().equals("")){
            sql += "lower(f.nome) like lower(:nome) and ";
        }
        
        sql +="f.ativo = true ";
        
        Query query = getEm().createQuery(sql, Fornecedor.class);
        
        if(fornecedor.getNome() != null && !fornecedor.getNome().equals("")){
            query.setParameter("nome", "%"+fornecedor.getNome()+"%");
        }
        
        return query.getResultList();
    }
    
    
    public List<Fornecedor> findFornecedorAutoComplete(String nome) {
        String sql = "select e from Fornecedor e where e.ativo=true ";

        if (nome != null && !nome.equals("")) {
            sql += " and lower (e.nome) like lower(:nome) ";
        }
        Query query = getEm().createQuery(sql, Fornecedor.class);

        if (nome != null && !nome.equals("")) {
            query.setParameter("nome", "%" + nome.replaceAll(" ", "%") + "%");
        }
        return query.getResultList();
    }
    
    public void desativar(Fornecedor fornecedor){
        fornecedor.setAtivo(false);
        getEm().merge(fornecedor);
    }
}
