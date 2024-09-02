package com.github.henriquemb.fornecedor_uninter.controller;

import com.github.henriquemb.fornecedor_uninter.bo.FornecedorBO;
import com.github.henriquemb.fornecedor_uninter.bo.NotaEntradaBO;
import com.github.henriquemb.fornecedor_uninter.bo.ProdutoBO;
import com.github.henriquemb.fornecedor_uninter.model.NotaEntrada;
import com.github.henriquemb.fornecedor_uninter.model.NotaEntradaItem;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/nota-entrada")
public class NotaEntradaController {
    @Autowired
    private NotaEntradaBO bo;

    @Autowired
    private FornecedorBO fbo;

    @Autowired
    private ProdutoBO pbo;

    @GetMapping(value = "/novo")
    public ModelAndView novo(ModelMap model) {
        model.addAttribute("notaEntrada", new NotaEntrada());
        model.addAttribute("fornecedores", fbo.buscarTodos());
        return new ModelAndView("/nota-entrada/formulario", model);
    }

    @PostMapping
    public String salva(@Valid @ModelAttribute NotaEntrada notaEntrada, BindingResult result, RedirectAttributes attr) {
        if(result.hasErrors()) {
            return "/nota-entrada/formulario";
        }

        if (notaEntrada.getId() == null) {
            bo.inserir(notaEntrada);
            attr.addFlashAttribute("feedback", "Nota de entrada cadastrada com sucesso.");
        } else {
            bo.atualizar(notaEntrada);
            attr.addFlashAttribute("feedback", "Nota de entrada atualizada com sucesso.");
        }

        return "redirect:/nota-entrada";
    }

    @GetMapping
    public ModelAndView lista(ModelMap model) {
        model.addAttribute("notas", bo.buscarTodos());
        return new ModelAndView("/nota-entrada/lista", model);
    }

    @GetMapping(value = "/edita/{id}")
    public ModelAndView edita(@PathVariable Long id, ModelMap model) {
        model.addAttribute("notaEntrada", bo.buscarPorId(id));
        model.addAttribute("fornecedores", fbo.buscarTodos());
        return new ModelAndView("/nota-entrada/formulario", model);
    }

    @GetMapping(value = "/remove/{id}")
    public String edita(@PathVariable Long id, RedirectAttributes attr) {
        bo.deletar(id);
        attr.addFlashAttribute("feedback", "Nota de entrada removida com sucesso.");

        return "redirect:/nota-entrada";
    }

    @GetMapping(value = "/{id}/item")
    public ModelAndView produto(@PathVariable("id") Long id, ModelMap model) {
        NotaEntrada ne = bo.buscarPorId(id);

        NotaEntradaItem nei = new NotaEntradaItem();
        nei.setNotaEntrada(ne);

        model.addAttribute("notaEntradaItem", nei);
        model.addAttribute("produtos", pbo.buscarTodos());
        return new ModelAndView("/nota-entrada-item/formulario", model);
    }
}
