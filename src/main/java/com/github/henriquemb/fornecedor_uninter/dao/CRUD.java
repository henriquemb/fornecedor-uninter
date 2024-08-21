package com.github.henriquemb.fornecedor_uninter.dao;

import java.util.List;

public interface CRUD<T, I> {
    T buscarPorId(I id);
    List<T> buscarTodos();
    void inserir(T t);
    void atualizar(T t);
    void deletar(I id);
}
