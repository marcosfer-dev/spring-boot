package com.hardware.marcos.hardwarestockapi.produtos;

import java.math.BigDecimal;

public record DadosListagemProduto(String nome, BigDecimal preco, int quantidade, Categoria categoria) {

    public DadosListagemProduto(Produto produto) {
        this(produto.getNome(), produto.getPreco(), produto.getQuantidade(), produto.getCategoria());
    }

}