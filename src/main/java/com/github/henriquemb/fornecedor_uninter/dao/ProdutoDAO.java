package com.github.henriquemb.fornecedor_uninter.dao;

import com.github.henriquemb.fornecedor_uninter.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProdutoDAO implements CRUD<Produto, Long> {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void inserir(Produto produto) {
        em.persist(produto);
    }

    @Override
    public Produto buscarPorId(Long id) {
        return em.find(Produto.class, id);
    }

    @Override
    public List<Produto> buscarTodos() {
        Query query = em.createQuery("SELECT p FROM Produto p");
        return (List<Produto>) query.getResultList();
    }

    @Override
    public void atualizar(Produto produto) {
        em.merge(produto);
    }

    @Override
    public void deletar(Long id) {
        em.remove(buscarPorId(id));
    }
}
