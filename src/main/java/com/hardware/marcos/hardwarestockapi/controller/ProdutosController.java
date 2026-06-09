package com.hardware.marcos.hardwarestockapi.controller;

import com.hardware.marcos.hardwarestockapi.produtos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Path;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoProduto> cadastrar(@RequestBody @Valid DadosCadastroProduto dados, UriComponentsBuilder uriBuilder) {

        var produto = new Produto(dados);
        repository.save(produto);

        var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoProduto(produto));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemProduto>> listar() {
        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemProduto::new).toList();

        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoProduto> atualizar(@RequestBody @Valid DadosAtualizarProduto dados) {
        var produto = repository.getReferenceById(dados.id());
        produto.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoProduto(produto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id) {
        var produto = repository.getReferenceById(id);
        produto.inativar();

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/reativar/{id}")
    @Transactional
    public ResponseEntity<Void> reativar(@PathVariable Long id) {
        var produto = repository.getReferenceById(id);
        produto.reativar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoProduto> detalhar(@PathVariable Long id) {
        var produto = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoProduto(produto));
    }
}