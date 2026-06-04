package com.hardware.marcos.hardwarestockapi.produtos;

import java.math.BigDecimal;

public record DadosDetalhamentoProduto(

        long id,
        String nome,
        BigDecimal preco,
        Integer quantidade,
        String descricao
)

{

    public DadosDetalhamentoProduto(Produto produto) {
        this(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getQuantidade(),
                produto.getDescricao()
        );
    }

}
