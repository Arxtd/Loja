package com.arthur.modelo;

import arthur.generico.EntidadeGenerica;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Arthur
 */
@Entity
public class Fornecedor extends EntidadeGenerica {

    @Id
    @javax.persistence.SequenceGenerator(name = "seq_fornecedor", sequenceName = "seq_fornecedor", initialValue = 1)
    @javax.persistence.GeneratedValue(generator = "seq_fornecedor", strategy = javax.persistence.GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    public Fornecedor() {
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
