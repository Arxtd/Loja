
package com.arthur.services;

import arthur.generico.Service;
import com.arthur.modelo.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author Arthur
 */
@Stateless
public class ProdutoService extends Service<Produto>{

    public ProdutoService() {
        super(Produto.class);
    }
    
    public List<Produto> findByAll(Produto produto){
        
        String sql = "select p from Produto p where ";
        if(produto.getNome() != null && !produto.getNome().equals("")){
            sql += "lower(p.nome) like lower(:nome) and ";
        }
        
        sql +="p.ativo = true ";
        
        Query query = getEm().createQuery(sql, Produto.class);
        
        if(produto.getNome() != null && !produto.getNome().equals("")){
            query.setParameter("nome", "%"+produto.getNome()+"%");
        }

        return query.getResultList();
    }
    
    public void desativar(Produto produto){
        produto.setAtivo(false);
        getEm().merge(produto);
    }
    
    
}
