package com.github.henriquemb.fornecedor_uninter.model.enums;

public enum ProdutoCategoria {
    CELULAR("Celular"),
    ELETRODOMESTICO("Eletrodoméstico"),
    INFORMATICA("Informática"),
    MOVEL("Móvel");

    private String descricao;

    ProdutoCategoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
