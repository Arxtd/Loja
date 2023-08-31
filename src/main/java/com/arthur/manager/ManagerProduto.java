package com.arthur.manager;

import com.arthur.modelo.*;
import com.arthur.services.*;
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
public class ManagerProduto implements Serializable {

    @EJB
    ProdutoService produtoservice;
    @EJB
    MarcaService marcaservico;
    @EJB
    TipoService tiposervico;
    @EJB
    FornecedorService fornecedorservico;

    private Produto produto;
    private List<Produto> produtos;

    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String visualizar = params.get("visualizar");
        String editar = params.get("editar");

        if (visualizar != null) {
            produto = produtoservice.find(Long.parseLong(visualizar));
        } else if (editar != null) {
            produto = produtoservice.find(Long.parseLong(editar));
        } else {
            produto = new Produto();
            produto.setMarca(new Marca());
            produto.setTipo(new Tipo());
            produtos = new ArrayList<>();
        }
        findAll();
    }

    public void adicionar() {
        if (produto.getId() == null) {
            produtoservice.salvar(produto);
            Mensagem.msg(produto.getNome() + " foi adicionado a tabela de produtos com sucesso!!");
            init();
        } else {
            produtoservice.atualizar(produto);
            Mensagem.msg("Operação realizada com sucesso!!");
        }

    }

    public void remover(Produto p) {
        produtoservice.desativar(p);
        produtos.remove(p);
    }

    public void findAll() {
        produtos = produtoservice.findAll();
    }

    public void pesquisar() {
        produtos = produtoservice.findByAll(produto);
    }

    public List<Marca> autocompleteMarca(String nome) {
        return marcaservico.findMarcaAutoComplete(nome);
    }

    public List<Tipo> autocompleteTipo(String nome) {
        return tiposervico.findTipoAutoComplete(nome);
    }
    
    public List<Fornecedor> autocompleteFornecedor(String nome) {
        return fornecedorservico.findFornecedorAutoComplete(nome);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
