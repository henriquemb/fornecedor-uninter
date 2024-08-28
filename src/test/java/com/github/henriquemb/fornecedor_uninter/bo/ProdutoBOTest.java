package com.github.henriquemb.fornecedor_uninter.bo;

import com.github.henriquemb.fornecedor_uninter.model.Produto;
import com.github.henriquemb.fornecedor_uninter.model.enums.ProdutoCategoria;
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
class ProdutoBOTest {
    @Autowired
    private ProdutoBO bo;

    @Test
    @Order(1)
    void inserir() {
        Produto produto = new Produto();
        produto.setNome("Teclado");
        produto.setCategoria(ProdutoCategoria.INFORMATICA);

        bo.inserir(produto);
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
        Produto produto = bo.buscarPorId(1L);
        produto.setCategoria(ProdutoCategoria.ELETRODOMESTICO);

        bo.atualizar(produto);
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