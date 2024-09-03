package com.github.henriquemb.fornecedor_uninter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "nota_entrada_item")
public class NotaEntradaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    @NotNull(message = "Produto é obrigatório")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "nota_entrada_id", nullable = false)
    @NotNull(message = "Nota de entrada é obrigatória")
    private NotaEntrada notaEntrada;

    @Column(nullable = false)
    @NotNull(message = "Quantidade é obrigatória")
    private int quantidade;

    @Column(name = "valor", nullable = false)
    @NotNull(message = "Valor é obrigatório")
    private float valor;

    @Transient
    private float total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public NotaEntrada getNotaEntrada() {
        return notaEntrada;
    }

    public void setNotaEntrada(NotaEntrada notaEntrada) {
        this.notaEntrada = notaEntrada;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getTotal() {
        return quantidade * valor;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
