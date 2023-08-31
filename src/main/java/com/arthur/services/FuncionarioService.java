package com.arthur.services;

import arthur.generico.Service;
import com.arthur.modelo.Funcionario;
import java.util.*;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Arthur
 */
@Stateless
public class FuncionarioService extends Service<Funcionario> {
    
    
    public FuncionarioService() {
        super(Funcionario.class);
    }

    public List<Funcionario> findByAll(Funcionario funcionario) {

        String sql = "select f from Funcionario f where ";
        if (funcionario.getNome() != null && !funcionario.getNome().equals("")) {
            sql += "lower(f.nome) like lower(:nome) and ";
        }

        sql += "f.ativo = true ";

        Query query = getEm().createQuery(sql, Funcionario.class);

        if (funcionario.getNome() != null && !funcionario.getNome().equals("")) {
            query.setParameter("nome", "%" + funcionario.getNome() + "%");
        }

        return query.getResultList();
    }

    public void desativar(Funcionario funcionario) {
        funcionario.setAtivo(false);
        getEm().merge(funcionario);
    }
    
}
