package com.github.henriquemb.fornecedor_uninter.controller;

import com.github.henriquemb.fornecedor_uninter.bo.NotaEntradaBO;
import com.github.henriquemb.fornecedor_uninter.bo.NotaEntradaItemBO;
import com.github.henriquemb.fornecedor_uninter.bo.ProdutoBO;
import com.github.henriquemb.fornecedor_uninter.model.NotaEntrada;
import com.github.henriquemb.fornecedor_uninter.model.NotaEntradaItem;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/nota-entrada-item")
public class NotaEntradaItemController {
    @Autowired
    private NotaEntradaItemBO bo;

    @Autowired
    private NotaEntradaBO nbo;

    @Autowired
    private ProdutoBO pbo;

    @PostMapping
    public String salva(@Valid @ModelAttribute NotaEntradaItem notaEntradaItem, BindingResult result, RedirectAttributes attr, ModelMap model) {
        if (notaEntradaItem.getProduto().getId() == null) {
            result.rejectValue("produto", "field.required");
        }

        if (bo.itemExistente(notaEntradaItem)) {
            result.rejectValue("produto", "duplicate");
        }

        if (result.hasErrors()) {
            model.addAttribute("produtos", pbo.buscarTodos());
            return "/nota-entrada-item/formulario";
        }

        NotaEntrada nt = nbo.buscarPorId(notaEntradaItem.getNotaEntrada().getId());
        notaEntradaItem.setNotaEntrada(nt);

        if (notaEntradaItem.getId() == null) {
            bo.inserir(notaEntradaItem);
            attr.addFlashAttribute("feedback", "Item da nota de entrada cadastrada com sucesso.");
        } else {
            bo.atualizar(notaEntradaItem);
            attr.addFlashAttribute("feedback", "Item da nota de entrada atualizada com sucesso.");
        }

        return "redirect:/nota-entrada/edita/" + nt.getId();
    }
}
