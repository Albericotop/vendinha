package com.api.vendinha.controller;

import com.api.vendinha.model.Pedido;
import com.api.vendinha.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoCotroller {

    @Autowired
    PedidoRepository repository;

    @GetMapping
    public ResponseEntity<List<Pedido>> getPedido() {
        List<Pedido> pedido = repository.findAll();
        return ResponseEntity.ok(pedido);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Pedido>> getPedido(@PathVariable Integer id) {
        Optional<Pedido> pedido = repository.findById(id);
        return ResponseEntity.ok(pedido);
    }

    @PostMapping
    public ResponseEntity<Pedido> saveClinte(@RequestBody Pedido pedido) {
        Pedido pedidoSalva = repository.save(pedido);
        return ResponseEntity.ok(pedidoSalva);
    }

}
