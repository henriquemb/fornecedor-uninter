package com.github.henriquemb.fornecedor_uninter.bo;

import com.github.henriquemb.fornecedor_uninter.model.Cliente;
import com.github.henriquemb.fornecedor_uninter.model.Sexo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

/**
 * Anotação:
 * @DataJpaTest: Testes de repositórios JPA.
 * @WebMvcTest: Testes de controladores MVC, endpoints HTTP.
 * @SpringBootTest: Testes de integração completos.
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClienteBOTest {
    @Autowired
    private ClienteBO bo;

    @Test
    @Order(1)
    void inserir() {
        Cliente cliente = new Cliente();
        cliente.setNome("José da Silva");
        cliente.setCpf("12345678900");
        cliente.setDataNascimento(LocalDate.of(2000, 12, 1));
        cliente.setSexo(Sexo.MASCULINO);
        cliente.setTelefone("1198745621");
        cliente.setCelular("11998745621");
        cliente.setEmail("teste@teste.com");
        cliente.setAtivo(true);

        bo.inserir(cliente);
    }

    @Test
    @Order(2)
    void buscarPorId() {
        Cliente cliente = bo.buscarPorId(1L);

        System.out.println(cliente.toString());
    }

    @Test
    @Order(3)
    void buscarTodos() {
        bo.buscarTodos().forEach(cliente -> System.out.println(cliente.toString()));
    }

    @Test
    @Order(4)
    void atualizar() {
        Cliente cliente = bo.buscarPorId(1L);
        cliente.setNome("José da Silva Santos");
        bo.atualizar(cliente);
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


