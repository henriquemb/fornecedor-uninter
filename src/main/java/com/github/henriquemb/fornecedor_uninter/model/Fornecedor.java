package com.github.henriquemb.fornecedor_uninter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "O nome fantasia é obrigatório")
    @Size(min = 3, max = 50, message = "O nome fantasia deve ter entre 3 e 50 caracteres")
    private String nomeFantasia;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "A razão social é obrigatória")
    @Size(min = 3, max = 50, message = "A razão social deve ter entre 3 e 50 caracteres")
    private String razaoSocial;

    @Column(nullable = false, length = 14)
    @CNPJ(message = "CNPJ inválido")
    private String cnpj;

    @Column(length = 10)
    private String telefone;

    @Column(length = 50)
    @Email(message = "E-mail inválido")
    private String email;

    private boolean ativo;

    public Fornecedor() {
        this.ativo = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
