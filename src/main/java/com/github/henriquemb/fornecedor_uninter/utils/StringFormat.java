package com.github.henriquemb.fornecedor_uninter.utils;

public class StringFormat {
    public static String formatarNumero(String numero) {
        return numero.replaceAll("[^0-9]", "");
    }
}
