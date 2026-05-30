package com.hardware.marcos.hardwarestockapi.produtos;

import java.math.BigDecimal;

public record DadosListagemProduto(long id,String nome, BigDecimal preco, Integer quantidade, Categoria categoria) {

    public DadosListagemProduto(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getPreco(), produto.getQuantidade(), produto.getCategoria());
    }

}