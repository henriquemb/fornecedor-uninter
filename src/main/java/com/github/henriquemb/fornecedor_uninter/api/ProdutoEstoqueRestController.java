package com.github.henriquemb.fornecedor_uninter.api;

import com.github.henriquemb.fornecedor_uninter.bo.ProdutoBO;
import com.github.henriquemb.fornecedor_uninter.bo.ProdutoEstoqueBO;
import com.github.henriquemb.fornecedor_uninter.model.ProdutoEstoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
public class ProdutoEstoqueRestController {
    @Autowired
    private ProdutoEstoqueBO bo;

    @Autowired
    private ProdutoBO pbo;

    @GetMapping
    public List<ProdutoEstoque> buscarTodos() {
        return bo.buscarTodos();
    }

    @GetMapping("/{id}")
    public ProdutoEstoque buscarPorId(@PathVariable Long id) {
        return bo.buscarPorId(id);
    }

    @PostMapping
    public ProdutoEstoque inserir(@RequestBody ProdutoEstoque produtoEstoque) {
        produtoEstoque.setProduto(pbo.buscarPorId(produtoEstoque.getProduto().getId()));

        bo.inserir(produtoEstoque);
        return produtoEstoque;
    }

    @PutMapping("/{id}")
    public ProdutoEstoque atualizar(@PathVariable Long id, @RequestBody ProdutoEstoque produtoEstoque) {
        produtoEstoque.setId(id);
        produtoEstoque.setProduto(pbo.buscarPorId(produtoEstoque.getProduto().getId()));

        bo.atualizar(produtoEstoque);

        return produtoEstoque;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        bo.deletar(id);
    }
}
