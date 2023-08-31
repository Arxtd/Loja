package com.arthur.modelo;

import arthur.generico.EntidadeGenerica;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Arthur
 */
@Entity
public class Cargo extends EntidadeGenerica {

    @Id
    @javax.persistence.SequenceGenerator(name = "seq_cargo", sequenceName = "seq_cargo", initialValue = 1)
    @javax.persistence.GeneratedValue(generator = "seq_cargo", strategy = javax.persistence.GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    public Cargo() {
        ativo = true;
        dataCadastro = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

}
