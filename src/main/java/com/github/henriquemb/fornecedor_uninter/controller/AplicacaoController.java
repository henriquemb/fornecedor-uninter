package com.github.henriquemb.fornecedor_uninter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AplicacaoController {
    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String logout() {
        return "redirect:/login";
    }
}