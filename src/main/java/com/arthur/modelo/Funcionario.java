package com.arthur.modelo;

import arthur.generico.EntidadeGenerica;
import com.arthur.enums.Sexo;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Arthur
 */
@Entity
public class Funcionario extends EntidadeGenerica {

    @Id
    @javax.persistence.SequenceGenerator(name = "seq_funcionario", sequenceName = "seq_funcionario", initialValue = 1)
    @javax.persistence.GeneratedValue(generator = "seq_funcionario", strategy = javax.persistence.GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    private String telefone;
    private String email;
    @OneToOne
    private Cargo cargo;
    private int idade;
    @Column(scale = 2, precision = 10)
    private BigDecimal salario;

    public Funcionario() {
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

}
