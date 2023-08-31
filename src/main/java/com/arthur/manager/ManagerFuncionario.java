package com.arthur.manager;

import com.arthur.enums.Sexo;
import com.arthur.modelo.Cargo;
import com.arthur.modelo.Funcionario;
import com.arthur.services.*;
import com.arthur.util.Mensagem;
import java.io.Serializable;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Arthur
 */
@Named
@ViewScoped
public class ManagerFuncionario implements Serializable {

    @EJB
    FuncionarioService funcionarioservice;
    @EJB
    CargoService cargoservice;

    private Funcionario funcionario;
    private List<Funcionario> funcionarios;

    @PostConstruct
    public void init() {

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String visualizar = params.get("visualizar");
        String editar = params.get("editar");

        if (visualizar != null) {
            funcionario = funcionarioservice.find(Long.parseLong(visualizar));
        } else if (editar != null) {
            funcionario = funcionarioservice.find(Long.parseLong(editar));
        } else {
            funcionario = new Funcionario();
            funcionario.setCargo(new Cargo());
            funcionarios = new ArrayList<>();
        }

        findAll();
    }

    public void adicionar() {
        if (funcionario.getId() == null) {
            funcionarioservice.salvar(funcionario);
            Mensagem.msg(funcionario.getNome() + " foi adicionado a tabela de funcionarios com sucesso!!");
            init();

        } else {
            funcionarioservice.atualizar(funcionario);
            Mensagem.msg("Operação realizada com sucesso!!");
        }

    }

    public void remover(Funcionario f) {
        funcionarioservice.desativar(f);
        funcionarios.remove(f);
    }

    public void pesquisar() {
        funcionarios = funcionarioservice.findByAll(funcionario);
    }

    public void findAll() {
        funcionarios = funcionarioservice.findAll();
    }

    public List<Cargo> autocompleteCargo(String nome) {
        return cargoservice.findCargoAutoComplete(nome);
    }

    public List<SelectItem> getSexo() {
        List<SelectItem> items = new ArrayList<>();
        for (Sexo item : Sexo.values()) {
            items.add(new SelectItem(item, item.getNome()));
        }
        return items;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
