package com.github.henriquemb.fornecedor_uninter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estoque")
public class EstoqueController {

    @GetMapping
    public String lista() {
        return "/estoque/lista";
    }
}
