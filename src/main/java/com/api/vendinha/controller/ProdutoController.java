package com.api.vendinha.controller;

import com.api.vendinha.model.Produto;
import com.api.vendinha.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

public class ProdutoController {
    @Autowired
    ProdutoRepository repository;

    @GetMapping
    public ResponseEntity<List<Produto>> getProduto() {
        List<Produto> produto = repository.findAll();
        return ResponseEntity.ok(produto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Produto>> getProduto(@PathVariable Integer id) {
        Optional<Produto> produto = repository.findById(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> saveClinte(@RequestBody Produto produto) {
        Produto produtoSalva = repository.save(produto);
        return ResponseEntity.ok(produtoSalva);
    }

}
