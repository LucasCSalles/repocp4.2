package com.github.lucascsalles.CP22.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.lucascsalles.CP22.model.Carro;
import com.github.lucascsalles.CP22.repository.CarroRepository;

@RestController
@RequestMapping("api/${api.version}/carros")
public class CarroController {

    @Autowired
    private CarroRepository repository;

     @PostMapping
    public ResponseEntity<Carro> create(@RequestBody Carro carro) {         
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(carro));
    }

    @GetMapping("/{id}")    
    public ResponseEntity<Carro> findById(@PathVariable Long id) { 
        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());        
    }
        
    @GetMapping    
    public ResponseEntity<List<Carro>> findAll() {        
        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> update(@PathVariable Long id, 
                                @RequestBody Carro carro) {

        Optional<Carro> optCliente = repository.findById(id);

        if (optCliente.isPresent()) {
            carro.setId(id);
            Carro clienteAlterado = repository.save(carro);
            return ResponseEntity.ok(clienteAlterado);
        } else {
            return ResponseEntity.notFound().build();
        }     
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) { 
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
 
    }

}
