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
    private Integer quantidade;

    @Column(name = "valor", nullable = false)
    @NotNull(message = "Valor é obrigatório")
    private Float valor;

    @Transient
    private Float total;

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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Float getTotal() {
        if (quantidade == null || valor == null)
            return 0f;

        return quantidade * valor;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
