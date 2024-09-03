package com.github.henriquemb.fornecedor_uninter.dao;

import com.github.henriquemb.fornecedor_uninter.model.NotaEntradaItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class NotaEntradaItemDAO implements CRUD<NotaEntradaItem, Long> {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void inserir(NotaEntradaItem notaEntradaItem) {
        em.persist(notaEntradaItem);
    }

    @Override
    public NotaEntradaItem buscarPorId(Long id) {
        return em.find(NotaEntradaItem.class, id);
    }

    @Override
    public List<NotaEntradaItem> buscarTodos() {
        Query query = em.createQuery("SELECT nei FROM NotaEntradaItem nei");
        return (List<NotaEntradaItem>) query.getResultList();
    }

    @Override
    public void atualizar(NotaEntradaItem notaEntradaItem) {
        em.merge(notaEntradaItem);
    }

    @Override
    public void deletar(Long id) {
        em.remove(buscarPorId(id));
    }

    public List<NotaEntradaItem> buscarPorNotaEntradaId(Long notaEntradaId) {
        Query query = em.createQuery("SELECT nei FROM NotaEntradaItem nei WHERE nei.notaEntrada.id = :notaEntradaId");
        query.setParameter("notaEntradaId", notaEntradaId);
        return (List<NotaEntradaItem>) query.getResultList();
    }
}
