package com.github.henriquemb.fornecedor_uninter.controller;

import com.github.henriquemb.fornecedor_uninter.bo.ClienteBO;
import com.github.henriquemb.fornecedor_uninter.model.Cliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

    @PostMapping
    public String salva(@Valid @ModelAttribute Cliente cliente, BindingResult result) {
        if(result.hasErrors()) {
            return "/cliente/formulario";
        }

        bo.inserirOuAtualizar(cliente);
        return "redirect:/clientes";
    }

    @GetMapping
    public ModelAndView lista(ModelMap model) {
        model.addAttribute("clientes", bo.buscarTodos());
        return new ModelAndView("/cliente/lista", model);
    }

    @GetMapping(value = "/edita/{id}")
    public ModelAndView edita(@PathVariable Long id, ModelMap model) {
        model.addAttribute("cliente", bo.buscarPorId(id));
        return new ModelAndView("/cliente/formulario", model);
    }

    @GetMapping(value = "/ativa/{id}")
    public String ativa(@PathVariable Long id) {
        bo.ativar(id);
        return "redirect:/clientes";
    }

    @GetMapping(value = "/inativa/{id}")
    public String inativa(@PathVariable Long id) {
        bo.inativar(id);
        return "redirect:/clientes";
    }
}
