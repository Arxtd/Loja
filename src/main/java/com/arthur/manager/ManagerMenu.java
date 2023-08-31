package com.arthur.manager;

import java.io.Serializable;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Arthur
 */
@Named
@ViewScoped
public class ManagerMenu implements Serializable {

    private String mensagem;
    Calendar calendario = Calendar.getInstance();
    static int horas = Calendar.HOUR_OF_DAY;

    @PostConstruct
    public void horas() {
        if (horas < 12) {
            mensagem = "Bom dia!";
        }
        if (horas > 12 && horas < 18) {
            mensagem = "Boa tarde!";
        }
        if ( horas > 18){
            mensagem = "Boa noite!";
        }

    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
