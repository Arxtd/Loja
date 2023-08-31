package com.arthur.enums;

/**
 *
 * @author Arthur
 */
public enum Sexo {
    MASCULINO(1, "Masculino", "MA"),
    FEMININO(2, "Feminino", "FE");
    private Integer valor;
    private String nome;
    private String sigla;

    private Sexo(Integer valor, String nome, String sigla) {
        this.valor = valor;
        this.nome = nome;
        this.sigla = sigla;

    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

}
