package com.github.henriquemb.fornecedor_uninter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "nota_entrada")
public class NotaEntrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora", nullable = false, columnDefinition = "DATETIME")
    @NotNull(message = "Data e hora são obrigatórios")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Fornecedor fornecedor;

    @OneToMany(mappedBy = "notaEntrada", cascade = CascadeType.ALL)
    private List<NotaEntradaItem> itens;

    @Transient
    private float total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<NotaEntradaItem> getItens() {
        return itens;
    }

    public void setItens(List<NotaEntradaItem> itens) {
        this.itens = itens;
    }

    public float getTotal() {
        if (itens == null)
            return 0f;

        return itens.stream().map(NotaEntradaItem::getTotal).reduce(0f, Float::sum);
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
