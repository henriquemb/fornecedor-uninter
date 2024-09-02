package com.github.henriquemb.fornecedor_uninter.controller;

import com.github.henriquemb.fornecedor_uninter.bo.ProdutoBO;
import com.github.henriquemb.fornecedor_uninter.model.Produto;
import com.github.henriquemb.fornecedor_uninter.model.enums.ProdutoCategoria;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoBO bo;

    @GetMapping(value = "/novo")
    public ModelAndView novo(ModelMap model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("categorias", ProdutoCategoria.values());
        return new ModelAndView("/produto/formulario", model);
    }

    @PostMapping
    public String salva(@Valid @ModelAttribute Produto produto, BindingResult result, RedirectAttributes attr) {
        if(result.hasErrors()) {
            return "/produto/formulario";
        }

        if (produto.getId() == null) {
            bo.inserir(produto);
            attr.addFlashAttribute("feedback", "Produto cadastrado com sucesso.");
        } else {
            bo.atualizar(produto);
            attr.addFlashAttribute("feedback", "Produto atualizado com sucesso.");
        }

        return "redirect:/produtos";
    }

    @GetMapping
    public ModelAndView lista(ModelMap model) {
        model.addAttribute("produtos", bo.buscarTodos());
        return new ModelAndView("/produto/lista", model);
    }

    @GetMapping(value = "/edita/{id}")
    public ModelAndView edita(@PathVariable Long id, ModelMap model) {
        model.addAttribute("produto", bo.buscarPorId(id));
        model.addAttribute("categorias", ProdutoCategoria.values());
        return new ModelAndView("/produto/formulario", model);
    }

    @GetMapping(value = "/ativa/{id}")
    public String ativa(@PathVariable Long id, RedirectAttributes attr) {
        bo.ativar(id);
        attr.addFlashAttribute("feedback", "Produto ativado com sucesso.");

        return "redirect:/produtos";
    }

    @GetMapping(value = "/inativa/{id}")
    public String inativa(@PathVariable Long id, RedirectAttributes attr) {
        bo.inativar(id);
        attr.addFlashAttribute("feedback", "Produto desativado com sucesso.");
        return "redirect:/produtos";
    }
}
