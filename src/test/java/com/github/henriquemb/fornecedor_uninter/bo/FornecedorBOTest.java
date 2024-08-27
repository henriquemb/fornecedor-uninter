package com.github.henriquemb.fornecedor_uninter.bo;

import com.github.henriquemb.fornecedor_uninter.model.Fornecedor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FornecedorBOTest {

    @Autowired
    private FornecedorBO bo;

    @Test
    @Order(1)
    void inserir() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNomeFantasia("Nome fantasia");
        fornecedor.setRazaoSocial("Razão Social");
        fornecedor.setCnpj("18215306000120");
        fornecedor.setEmail("email@teste.com");
        fornecedor.setTelefone("1198745621");

        bo.inserir(fornecedor);
    }

    @Test
    @Order(2)
    void buscarPorId() {
        bo.buscarPorId(1L);
    }

    @Test
    @Order(3)
    void buscarTodos() {
        bo.buscarTodos();
    }

    @Test
    @Order(4)
    void atualizar() {
        Fornecedor fornecedor = bo.buscarPorId(1L);
        fornecedor.setEmail("teste@teste.com");

        bo.atualizar(fornecedor);
    }

    @Test
    @Order(5)
    void inativar() {
        bo.inativar(1L);
    }

    @Test
    @Order(6)
    void ativar() {
        bo.ativar(1L);
    }

    @Test
    @Order(7)
    void deletar() {
        bo.deletar(1L);
    }
}