package com.github.henriquemb.fornecedor_uninter.controller;

import com.github.henriquemb.fornecedor_uninter.bo.ClienteBO;
import com.github.henriquemb.fornecedor_uninter.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteBO bo;

    @GetMapping(value = "/novo")
    public ModelAndView novo(ModelMap model) {
        model.addAttribute("cliente", new Cliente());
        return new ModelAndView("/cliente/formulario", model);
    }
}
