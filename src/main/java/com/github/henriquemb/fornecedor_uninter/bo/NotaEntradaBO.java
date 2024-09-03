package com.github.henriquemb.fornecedor_uninter.bo;

import com.github.henriquemb.fornecedor_uninter.dao.CRUD;
import com.github.henriquemb.fornecedor_uninter.dao.NotaEntradaDAO;
import com.github.henriquemb.fornecedor_uninter.model.NotaEntrada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaEntradaBO implements CRUD<NotaEntrada, Long> {
    @Autowired
    private NotaEntradaDAO dao;

    @Override
    public void inserir(NotaEntrada notaEntrada) {
        dao.inserir(notaEntrada);
    }

    @Override
    public NotaEntrada buscarPorId(Long id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<NotaEntrada> buscarTodos() {
        return dao.buscarTodos();
    }

    @Override
    public void atualizar(NotaEntrada notaEntrada) {
        dao.atualizar(notaEntrada);
    }

    @Override
    public void deletar(Long id) {
        dao.deletar(id);
    }
}
