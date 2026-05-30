package com.hardware.marcos.hardwarestockapi.produtos;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record DadosCadastroProduto(

        @NotBlank
        String nome,

        String descricao,

        @NotNull
        @Positive
        BigDecimal preco,

        @PositiveOrZero
        Integer quantidade,

        @NotBlank
        String sku,

        @Enumerated
        Categoria categoria
    ) {

    //Padrão DTO
}