package com.arthur.manager;

import com.arthur.modelo.Fornecedor;
import com.arthur.services.FornecedorService;
import com.arthur.util.Mensagem;
import java.io.Serializable;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Arthur
 */
@Named
@ViewScoped
public class ManagerFornecedor implements Serializable {

    @EJB
    FornecedorService fornecedorservice;
    private Fornecedor fornecedor;
    private List<Fornecedor> fornecedores = new ArrayList<>();

    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String visualizar = params.get("visualizar");
        String editar = params.get("editar");

        if (visualizar != null) {
            fornecedor = fornecedorservice.find(Long.parseLong(visualizar));
        } else if (editar != null) {
            fornecedor = fornecedorservice.find(Long.parseLong(editar));
        } else {
            fornecedor = new Fornecedor();
        }
        
        findAll();
    }

    public void adicionar() {
        if (fornecedor.getId() == null) {
            fornecedorservice.salvar(fornecedor);
            Mensagem.msg(fornecedor.getNome() + " foi adicionado a tabela de fornecedores com sucesso!!");
            init();

        } else {
            fornecedorservice.atualizar(fornecedor);
            Mensagem.msg("Operação realizada com sucesso!!");
        }
    }

    public void remover(Fornecedor f) {
        fornecedorservice.desativar(f);
        fornecedores.remove(f);
    }

    public void findAll() {
        fornecedores = fornecedorservice.findAll();
    }

    public void pesquisar() {
        fornecedores = fornecedorservice.findByAll(fornecedor);
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

}
