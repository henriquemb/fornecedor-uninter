package com.github.henriquemb.fornecedor_uninter.dao;

import java.util.List;

public interface CRUD<T, I> {
    void inserir(T t);
    T buscarPorId(I id);
    List<T> buscarTodos();
    void atualizar(T t);
    void deletar(I id);
}
