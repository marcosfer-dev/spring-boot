package com.hardware.marcos.hardwarestockapi.produtos;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosAtualizarProduto(

        @NotNull
        long id,
        String nome,
        BigDecimal preco,
        Integer quantidade,
        String descricao) {

}
