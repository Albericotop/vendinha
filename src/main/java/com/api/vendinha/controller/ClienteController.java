package com.api.vendinha.controller;

import com.api.vendinha.model.Cliente;
import com.api.vendinha.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
    @Autowired
    ClienteRepository repository;

    @GetMapping
    public ResponseEntity<List<Cliente>> getCliente() {
        List<Cliente> cliente = repository.findAll();
         return ResponseEntity.ok(cliente);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Cliente>> getCliente(@PathVariable Integer id) {
        Optional<Cliente> cliente = repository.findById(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> saveClinte(@RequestBody Cliente cliente) {
        Cliente clienteSalva = repository.save(cliente);
        return ResponseEntity.ok(clienteSalva);
    }


}