package com.hardware.marcos.hardwarestockapi.controller;

import com.hardware.marcos.hardwarestockapi.produtos.DadosCadastroProduto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroProduto dados) {
        System.out.println(dados);
    }


}
