
package com.arthur.manager;

import com.arthur.modelo.Cargo;
import com.arthur.services.CargoService;
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
public class ManagerCargo implements Serializable{
    
    @EJB
    CargoService cargoservice;
    private Cargo cargo;
    private List<Cargo> cargos = new ArrayList<>();
    
    @PostConstruct
    public void init(){
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String visualizar = params.get("visualizar");
        String editar = params.get("editar");

        if (visualizar != null) {
            cargo = cargoservice.find(Long.parseLong(visualizar));
        } else if (editar != null) {
            cargo = cargoservice.find(Long.parseLong(editar));
        } else {
            cargo = new Cargo();
        }
        findAll();
    }
    
    public void adicionar() {
        if (cargo.getId() == null) {
            cargoservice.salvar(cargo);
            Mensagem.msg(cargo.getNome() + " foi adicionado a tabela de cargos com sucesso!!");
            init();
            
        } else {
            cargoservice.atualizar(cargo);
            Mensagem.msg("Operação realizada com sucesso!!");
        }
        
    }
    
    public void pesquisar(){
        cargos = cargoservice.findByAll(cargo);
    }
    
    public void remover(Cargo cargo){
        cargoservice.desativar(cargo);
        cargos.remove(cargo);
    }
    
    public void findAll(){
        cargos = cargoservice.findAll();
    }
    
    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }
    
    
}
