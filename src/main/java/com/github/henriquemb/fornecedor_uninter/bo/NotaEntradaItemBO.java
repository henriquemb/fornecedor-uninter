package com.github.henriquemb.fornecedor_uninter.bo;

import com.github.henriquemb.fornecedor_uninter.dao.CRUD;
import com.github.henriquemb.fornecedor_uninter.dao.NotaEntradaItemDAO;
import com.github.henriquemb.fornecedor_uninter.model.NotaEntradaItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaEntradaItemBO implements CRUD<NotaEntradaItem, Long> {
    @Autowired
    private NotaEntradaItemDAO dao;

    @Override
    public void inserir(NotaEntradaItem notaEntradaItem) {
        dao.inserir(notaEntradaItem);
    }

    @Override
    public NotaEntradaItem buscarPorId(Long id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<NotaEntradaItem> buscarTodos() {
        return dao.buscarTodos();
    }

    @Override
    public void atualizar(NotaEntradaItem notaEntradaItem) {
        dao.atualizar(notaEntradaItem);

    }

    @Override
    public void deletar(Long id) {
        dao.deletar(id);
    }
}
