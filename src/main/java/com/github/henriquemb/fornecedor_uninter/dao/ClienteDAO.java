package com.github.henriquemb.fornecedor_uninter.dao;

import com.github.henriquemb.fornecedor_uninter.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ClienteDAO implements CRUD<Cliente, Long> {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Cliente buscarPorId(Long id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> buscarTodos() {
        Query query = em.createQuery("SELECT c FROM Cliente c");
        return (List<Cliente>) query.getResultList();
    }

    @Override
    public void inserir(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void atualizar(Cliente cliente) {
        em.merge(cliente);
    }

    @Override
    public void deletar(Long id) {
        em.remove(buscarPorId(id));
    }
}
