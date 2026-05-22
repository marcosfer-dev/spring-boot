package com.hardware.marcos.hardwarestockapi.controller;

import com.hardware.marcos.hardwarestockapi.produtos.DadosCadastroProduto;
import com.hardware.marcos.hardwarestockapi.produtos.Produto;
import com.hardware.marcos.hardwarestockapi.produtos.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroProduto dados) {
        repository.save(new Produto(dados));
    }


}
