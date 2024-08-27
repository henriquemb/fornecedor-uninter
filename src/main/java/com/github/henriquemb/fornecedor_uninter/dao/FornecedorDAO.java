package com.github.henriquemb.fornecedor_uninter.dao;

import com.github.henriquemb.fornecedor_uninter.model.Fornecedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class FornecedorDAO implements CRUD<Fornecedor, Long>{
    @PersistenceContext
    private EntityManager em;

    @Override
    public Fornecedor buscarPorId(Long id) {
        return em.find(Fornecedor.class, id);
    }

    @Override
    public List<Fornecedor> buscarTodos() {
        Query query = em.createQuery("SELECT c FROM Fornecedor c");
        return (List<Fornecedor>) query.getResultList();
    }

    @Override
    public void inserir(Fornecedor fornecedor) {
        em.persist(fornecedor);
    }

    @Override
    public void atualizar(Fornecedor fornecedor) {
        em.merge(fornecedor);
    }

    @Override
    public void deletar(Long id) {
        em.remove(buscarPorId(id));
    }
}
