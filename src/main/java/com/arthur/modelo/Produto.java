package com.arthur.modelo;

import arthur.generico.EntidadeGenerica;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Arthur
 */
@Entity
public class Produto extends EntidadeGenerica {

    @Id
    @javax.persistence.SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", initialValue = 1)
    @javax.persistence.GeneratedValue(generator = "seq_produto", strategy = javax.persistence.GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    @OneToOne
    private Marca marca;
    @OneToOne
    private Tipo tipo;
    @OneToOne
    private Fornecedor fornecedor;
    @Column(scale = 2, precision = 10)
    private BigDecimal precodecompra;
    @Column(scale = 2, precision = 10)
    private BigDecimal precodevenda;
    private double grama;
    private double ml;
    private int quantidade;
    private int litro;
    private int kilo;
    private String observacao;

    public Produto() {
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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public BigDecimal getPrecodecompra() {
        return precodecompra;
    }

    public void setPrecodecompra(BigDecimal precodecompra) {
        this.precodecompra = precodecompra;
    }

    public BigDecimal getPrecodevenda() {
        return precodevenda;
    }

    public void setPrecodevenda(BigDecimal precodevenda) {
        this.precodevenda = precodevenda;
    }

    public double getGrama() {
        return grama;
    }

    public void setGrama(double grama) {
        this.grama = grama;
    }

    public double getMl() {
        return ml;
    }

    public void setMl(double ml) {
        this.ml = ml;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getLitro() {
        return litro;
    }

    public void setLitro(int litro) {
        this.litro = litro;
    }

    public int getKilo() {
        return kilo;
    }

    public void setKilo(int kilo) {
        this.kilo = kilo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.marca);
        hash = 59 * hash + Objects.hashCode(this.tipo);
        hash = 59 * hash + Objects.hashCode(this.fornecedor);
        hash = 59 * hash + Objects.hashCode(this.precodecompra);
        hash = 59 * hash + Objects.hashCode(this.precodevenda);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.grama) ^ (Double.doubleToLongBits(this.grama) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.ml) ^ (Double.doubleToLongBits(this.ml) >>> 32));
        hash = 59 * hash + this.quantidade;
        hash = 59 * hash + this.litro;
        hash = 59 * hash + this.kilo;
        hash = 59 * hash + Objects.hashCode(this.observacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (Double.doubleToLongBits(this.grama) != Double.doubleToLongBits(other.grama)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ml) != Double.doubleToLongBits(other.ml)) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (this.litro != other.litro) {
            return false;
        }
        if (this.kilo != other.kilo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        if (!Objects.equals(this.precodecompra, other.precodecompra)) {
            return false;
        }
        return Objects.equals(this.precodevenda, other.precodevenda);
    }

}
