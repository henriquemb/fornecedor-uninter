package com.github.henriquemb.fornecedor_uninter.bo;

import com.github.henriquemb.fornecedor_uninter.dao.CRUD;
import com.github.henriquemb.fornecedor_uninter.dao.ClienteDAO;
import com.github.henriquemb.fornecedor_uninter.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteBO implements CRUD<Cliente, Long> {
    @Autowired
    private ClienteDAO dao;

    @Override
    public Cliente buscarPorId(Long id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return dao.buscarTodos();
    }

    @Override
    public void inserir(Cliente cliente) {
        dao.inserir(cliente);
    }

    @Override
    public void atualizar(Cliente cliente) {
        dao.atualizar(cliente);
    }

    @Override
    public void deletar(Long id) {
        dao.deletar(id);
    }

    public void inativar(Long id) {
        Cliente cliente = buscarPorId(id);
        cliente.setAtivo(false);
        atualizar(cliente);
    }

    public void ativar(Long id) {
        Cliente cliente = buscarPorId(id);
        cliente.setAtivo(true);
        atualizar(cliente);
    }
}
