package com.github.henriquemb.fornecedor_uninter.controller;

import com.github.henriquemb.fornecedor_uninter.bo.FornecedorBO;
import com.github.henriquemb.fornecedor_uninter.model.Fornecedor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorBO bo;

    @GetMapping(value = "/novo")
    public ModelAndView novo(ModelMap model) {
        model.addAttribute("fornecedor", new Fornecedor());
        return new ModelAndView("/fornecedor/formulario", model);
    }

    @PostMapping
    public String salva(@Valid @ModelAttribute Fornecedor fornecedor, BindingResult result, RedirectAttributes attr) {
        if(result.hasErrors()) {
            return "/fornecedor/formulario";
        }

        if (fornecedor.getId() == null) {
            bo.inserir(fornecedor);
            attr.addFlashAttribute("feedback", "Fornecedor cadastrado com sucesso.");
        } else {
            bo.atualizar(fornecedor);
            attr.addFlashAttribute("feedback", "Fornecedor atualizado com sucesso.");
        }

        return "redirect:/fornecedores";
    }

    @GetMapping
    public ModelAndView lista(ModelMap model) {
        model.addAttribute("fornecedores", bo.buscarTodos());
        return new ModelAndView("/fornecedor/lista", model);
    }

    @GetMapping(value = "/edita/{id}")
    public ModelAndView edita(@PathVariable Long id, ModelMap model) {
        model.addAttribute("fornecedor", bo.buscarPorId(id));
        return new ModelAndView("/fornecedor/formulario", model);
    }

    @GetMapping(value = "/ativa/{id}")
    public String ativa(@PathVariable Long id, RedirectAttributes attr) {
        bo.ativar(id);
        attr.addFlashAttribute("feedback", "Fornecedor ativado com sucesso.");

        return "redirect:/fornecedores";
    }

    @GetMapping(value = "/inativa/{id}")
    public String inativa(@PathVariable Long id, RedirectAttributes attr) {
        bo.inativar(id);
        attr.addFlashAttribute("feedback", "Fornecedor desativado com sucesso.");
        return "redirect:/fornecedores";
    }
}
