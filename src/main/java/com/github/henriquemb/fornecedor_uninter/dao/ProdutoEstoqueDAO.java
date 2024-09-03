package com.github.henriquemb.fornecedor_uninter.dao;

import com.github.henriquemb.fornecedor_uninter.model.ProdutoEstoque;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProdutoEstoqueDAO implements CRUD<ProdutoEstoque, Long> {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void inserir(ProdutoEstoque produtoEstoque) {
        em.persist(produtoEstoque);
    }

    @Override
    public ProdutoEstoque buscarPorId(Long id) {
        return em.find(ProdutoEstoque.class, id);
    }

    @Override
    public List<ProdutoEstoque> buscarTodos() {
        Query query = em.createQuery("SELECT pe FROM ProdutoEstoque pe");
        return (List<ProdutoEstoque>) query.getResultList();
    }

    @Override
    public void atualizar(ProdutoEstoque produtoEstoque) {
        em.merge(produtoEstoque);
    }

    @Override
    public void deletar(Long id) {
        em.remove(buscarPorId(id));
    }
}
