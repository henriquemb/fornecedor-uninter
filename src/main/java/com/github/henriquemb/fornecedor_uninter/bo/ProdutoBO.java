package com.github.henriquemb.fornecedor_uninter.bo;

import com.github.henriquemb.fornecedor_uninter.dao.CRUD;
import com.github.henriquemb.fornecedor_uninter.dao.ProdutoDAO;
import com.github.henriquemb.fornecedor_uninter.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoBO implements CRUD<Produto, Long> {
    @Autowired
    private ProdutoDAO dao;

    @Override
    public void inserir(Produto produto) {
        dao.inserir(produto);
    }

    @Override
    public Produto buscarPorId(Long id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<Produto> buscarTodos() {
        return dao.buscarTodos();
    }

    @Override
    public void atualizar(Produto produto) {
        dao.atualizar(produto);

    }

    @Override
    public void deletar(Long id) {
        dao.deletar(id);
    }

    public void ativar(Long id) {
        Produto produto = buscarPorId(id);
        produto.setAtivo(true);
        atualizar(produto);
    }

    public void inativar(Long id) {
        Produto produto = buscarPorId(id);
        produto.setAtivo(false);
        atualizar(produto);
    }
}
