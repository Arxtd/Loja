package com.arthur.manager;

import com.arthur.modelo.Tipo;
import com.arthur.services.TipoService;
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
public class ManagerTipo implements Serializable {

    @EJB
    TipoService tiposervice;

    private Tipo tipo;
    private List<Tipo> tipos = new ArrayList<>();

    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String visualizar = params.get("visualizar");
        String editar = params.get("editar");

        if (visualizar != null) {
            tipo = tiposervice.find(Long.parseLong(visualizar));
        } else if (editar != null) {
            tipo = tiposervice.find(Long.parseLong(editar));
        } else {
            tipo = new Tipo();
        }

        findAll();
    }

    public void adicionar() {

        if (tipo.getId() == null) {

            tiposervice.salvar(tipo);
            Mensagem.msg(tipo.getNome() + " foi adicionado a tabela de tipos com sucesso!!");
            init();

        } else {
            tiposervice.atualizar(tipo);
            Mensagem.msg("Operação realizada com sucesso!!");
        }

    }

    public void findAll() {
        tipos = tiposervice.findAll();
    }

    public void pesquisar() {
        tipos = tiposervice.findByAll(tipo);
    }

    public void remover(Tipo p) {
        tiposervice.desativar(p);
        tipos.remove(p);
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public List<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(List<Tipo> tipos) {
        this.tipos = tipos;
    }

}
