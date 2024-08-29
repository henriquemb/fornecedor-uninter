package com.github.henriquemb.fornecedor_uninter.dao;

import com.github.henriquemb.fornecedor_uninter.model.NotaEntrada;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class NotaEntradaDAO implements CRUD<NotaEntrada, Long> {
    @Autowired
    private EntityManager em;

    @Override
    public void inserir(NotaEntrada notaEntrada) {
        em.persist(notaEntrada);
    }

    @Override
    public NotaEntrada buscarPorId(Long id) {
        return em.find(NotaEntrada.class, id);
    }

    @Override
    public List<NotaEntrada> buscarTodos() {
        Query query = em.createQuery("SELECT n FROM NotaEntrada n");
        return (List<NotaEntrada>) query.getResultList();
    }

    @Override
    public void atualizar(NotaEntrada notaEntrada) {
        em.merge(notaEntrada);
    }

    @Override
    public void deletar(Long id) {
        em.remove(buscarPorId(id));
    }
}
