package com.arthur.modelo;

import arthur.generico.EntidadeGenerica;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Arthur
 */
@Entity
public class Tipo extends EntidadeGenerica {

    @Id
    @javax.persistence.SequenceGenerator(name = "seq_tipo", sequenceName = "seq_tipo", initialValue = 1)
    @javax.persistence.GeneratedValue(generator = "seq_tipo", strategy = javax.persistence.GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    public Tipo() {
        ativo = true;
        dataCadastro = new Date();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nome;
    }

}
