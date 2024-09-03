package com.github.henriquemb.fornecedor_uninter.bo;

import com.github.henriquemb.fornecedor_uninter.dao.CRUD;
import com.github.henriquemb.fornecedor_uninter.dao.ProdutoEstoqueDAO;
import com.github.henriquemb.fornecedor_uninter.model.ProdutoEstoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoEstoqueBO implements CRUD<ProdutoEstoque, Long> {
    @Autowired
    private ProdutoEstoqueDAO dao;

    @Override
    public void inserir(ProdutoEstoque produtoEstoque) {
        dao.inserir(produtoEstoque);
    }

    @Override
    public ProdutoEstoque buscarPorId(Long id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<ProdutoEstoque> buscarTodos() {
        return dao.buscarTodos();
    }

    @Override
    public void atualizar(ProdutoEstoque produtoEstoque) {
        dao.atualizar(produtoEstoque);
    }

    @Override
    public void deletar(Long id) {
        dao.deletar(id);
    }
}
