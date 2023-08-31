
package com.arthur.modelo;

import arthur.generico.EntidadeGenerica;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Arthur
 */
@Entity
public class Marca extends EntidadeGenerica{
  
    @Id
    @javax.persistence.SequenceGenerator(name = "seq_marca", sequenceName = "seq_marca", initialValue = 1)
    @javax.persistence.GeneratedValue(generator = "seq_marca", strategy = javax.persistence.GenerationType.SEQUENCE)
    private Long id;
    
    private String nome;

    public Marca() {
        dataCadastro = new Date();
        ativo = true;
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


