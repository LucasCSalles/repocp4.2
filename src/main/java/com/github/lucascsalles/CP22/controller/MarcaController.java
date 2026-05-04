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

import com.github.lucascsalles.CP22.model.Marca;
import com.github.lucascsalles.CP22.repository.MarcaRepository;

@RestController
@RequestMapping("api/${api.version}/marcas")
public class MarcaController {

     @Autowired
    private MarcaRepository repository;

     @PostMapping
    public ResponseEntity<Marca> create(@RequestBody Marca marca) {         
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(marca));
    }

    @GetMapping("/{id}")    
    public ResponseEntity<Marca> findById(@PathVariable Long id) { 
        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());        
    }
        
    @GetMapping    
    public ResponseEntity<List<Marca>> findAll() {        
        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> update(@PathVariable Long id, 
                                @RequestBody Marca marca) {

        Optional<Marca> optCliente = repository.findById(id);

        if (optCliente.isPresent()) {
            marca.setId(id);
            Marca clienteAlterado = repository.save(marca);
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
