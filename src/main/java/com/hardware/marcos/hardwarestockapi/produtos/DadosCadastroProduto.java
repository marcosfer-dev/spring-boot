package com.hardware.marcos.hardwarestockapi.produtos;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record DadosCadastroProduto(

        @NotBlank(message = "nome não pode estar em branco")
        String nome,

        String descricao,

        @NotNull(message = "O preço é obrigatório.")
        @Positive(message = "O preço deve ser um valor maior que zero.")
        BigDecimal preco,

        @PositiveOrZero(message = "A quantidade não pode ser negativa.")
        Integer quantidade,

        @NotBlank(message = "O SKU é obrigatório e não pode estar em branco.")
        String sku,

        @NotNull(message = "A categoria é obrigatória.")
        @Enumerated
        Categoria categoria
    ) {

    //Padrão DTO
}