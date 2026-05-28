package com.hardware.marcos.hardwarestockapi.controller;

import com.hardware.marcos.hardwarestockapi.produtos.DadosCadastroProduto;
import com.hardware.marcos.hardwarestockapi.produtos.DadosListagemProduto;
import com.hardware.marcos.hardwarestockapi.produtos.Produto;
import com.hardware.marcos.hardwarestockapi.produtos.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroProduto dados) {
        repository.save(new Produto(dados));
    }

    @GetMapping
    public List<DadosListagemProduto> listar() {
        return repository.findAll().stream().map(DadosListagemProduto::new).toList();
    }

}