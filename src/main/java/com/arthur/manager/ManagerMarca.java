package com.arthur.manager;

import com.arthur.modelo.Marca;
import com.arthur.services.MarcaService;
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
public class ManagerMarca implements Serializable {

    @EJB
    MarcaService marcaService;

    private Marca marca;
    private List<Marca> marcas;

    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String visualizar = params.get("visualizar");
        String editar = params.get("editar");

        if (visualizar != null) {
            marca = marcaService.find(Long.parseLong(visualizar));
        } else if (editar != null) {
            marca = marcaService.find(Long.parseLong(editar));
        } else {
            marcas = new ArrayList<>();
            marca = new Marca();
        }
        findAll();
    }

    public void adicionar() {
        if (marca.getId() == null) {
            marcaService.salvar(marca);
            Mensagem.msg(marca.getNome() + " foi adicionado a tabela de marcas com sucesso!!");
            init();

        } else {
            marcaService.atualizar(marca);
            Mensagem.msg("Operação realizada com sucesso!!");
        }

    }

    public void findAll() {
        marcas = marcaService.findAll();
    }

    public void pesquisar() {
        marcas = marcaService.findByAll(marca);
    }

    public void remover(Marca m) {
        marcaService.desativar(m);
        marcas.remove(m);
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }

}
