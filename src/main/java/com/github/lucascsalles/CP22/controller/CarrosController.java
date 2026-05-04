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

import com.github.lucascsalles.CP22.model.Carros;
import com.github.lucascsalles.CP22.repository.CarrosRepository;

@RestController
@RequestMapping("api/${api.version}/carros")
public class CarrosController {

    @Autowired
    private CarrosRepository repository;

    @PostMapping("/create")
    public ResponseEntity<Carros> create(@RequestBody Carros carros){
        repository.save(carros);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(carros));
    }
   
    @GetMapping("/{id}")
    public ResponseEntity<Carros> findById(@PathVariable Long id){
        Optional<Carros> optProduto = repository.findById(id);
   return optProduto.map(p -> ResponseEntity.ok(p)).orElse(ResponseEntity.noContent().build());    
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Carros>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Carros> update(@PathVariable Long id, @RequestBody Carros carros){
       Optional<Carros> optProduto = repository.findById(id);
       if(optProduto.isPresent()){
        carros.setId(id);
        Carros produtoAlterado = repository.save(carros);
        return ResponseEntity.ok(produtoAlterado);
       } else {
        return ResponseEntity.notFound().build();
       }

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
