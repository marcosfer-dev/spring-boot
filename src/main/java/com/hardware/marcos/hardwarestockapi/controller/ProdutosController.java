package com.hardware.marcos.hardwarestockapi.controller;

import com.hardware.marcos.hardwarestockapi.produtos.*;
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

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarProduto dados) {
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);
    }
}