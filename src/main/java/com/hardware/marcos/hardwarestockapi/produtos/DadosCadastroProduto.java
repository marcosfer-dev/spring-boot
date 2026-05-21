package com.hardware.marcos.hardwarestockapi.produtos;

import java.math.BigDecimal;

public record DadosCadastroProduto(
        String nome,
        String descricao,
        BigDecimal preco,
        int quantidade,
        String sku,
        Categoria categoria
    ) {

    //Padrão DTO
}
