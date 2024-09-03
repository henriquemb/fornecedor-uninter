package com.github.henriquemb.fornecedor_uninter.bo;

import com.github.henriquemb.fornecedor_uninter.dao.CRUD;
import com.github.henriquemb.fornecedor_uninter.dao.NotaEntradaItemDAO;
import com.github.henriquemb.fornecedor_uninter.model.NotaEntradaItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    public List<NotaEntradaItem> buscarPorNotaEntradaId(Long id) {
        return dao.buscarPorNotaEntradaId(id);
    }

    public boolean itemExistente(NotaEntradaItem item) {
        List<NotaEntradaItem> itens = dao.buscarPorNotaEntradaId(item.getNotaEntrada().getId());

        if (item.getId() == null) {
            return itens.stream().anyMatch(i -> i.getProduto().getId().equals(item.getProduto().getId()));
        }
        else {
            return itens.stream().anyMatch(i -> !Objects.equals(i.getId(), item.getId()) && i.getProduto().getId().equals(item.getProduto().getId()));
        }
    }
}
