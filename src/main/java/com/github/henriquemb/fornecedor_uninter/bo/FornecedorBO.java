package com.github.henriquemb.fornecedor_uninter.bo;

import com.github.henriquemb.fornecedor_uninter.dao.CRUD;
import com.github.henriquemb.fornecedor_uninter.dao.FornecedorDAO;
import com.github.henriquemb.fornecedor_uninter.model.Fornecedor;
import com.github.henriquemb.fornecedor_uninter.utils.StringFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorBO implements CRUD<Fornecedor, Long> {
    @Autowired
    private FornecedorDAO dao;

    @Override
    public Fornecedor buscarPorId(Long id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<Fornecedor> buscarTodos() {
        return dao.buscarTodos();
    }

    @Override
    public void inserir(Fornecedor fornecedor) {
        fornecedor.setCnpj(StringFormat.formatarNumero(fornecedor.getCnpj()));
        fornecedor.setTelefone(StringFormat.formatarNumero(fornecedor.getTelefone()));

        dao.inserir(fornecedor);
    }

    @Override
    public void atualizar(Fornecedor fornecedor) {
        fornecedor.setCnpj(StringFormat.formatarNumero(fornecedor.getCnpj()));
        fornecedor.setTelefone(StringFormat.formatarNumero(fornecedor.getTelefone()));
        
        dao.atualizar(fornecedor);
    }

    @Override
    public void deletar(Long id) {
        dao.deletar(id);
    }

    public void inativar(Long id) {
        Fornecedor fornecedor = buscarPorId(id);
        fornecedor.setAtivo(false);
        atualizar(fornecedor);
    }

    public void ativar(Long id) {
        Fornecedor fornecedor = buscarPorId(id);
        fornecedor.setAtivo(true);
        atualizar(fornecedor);
    }
}
