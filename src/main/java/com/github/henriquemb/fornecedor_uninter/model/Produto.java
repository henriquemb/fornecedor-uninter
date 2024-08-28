package com.github.henriquemb.fornecedor_uninter.model;

import com.github.henriquemb.fornecedor_uninter.model.enums.ProdutoCategoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    private String nome;

    @Column(nullable = false)
    @NotNull(message = "A categoria é obrigatória")
    @Enumerated(EnumType.STRING)
    private ProdutoCategoria categoria;

    private boolean ativo;

    public Produto() {
        this.ativo = true;
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

    public ProdutoCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(ProdutoCategoria categoria) {
        this.categoria = categoria;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
