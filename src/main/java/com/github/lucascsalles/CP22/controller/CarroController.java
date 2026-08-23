package com.github.lucascsalles.CP22.controller;

import java.util.List;

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

import com.github.lucascsalles.CP22.dto.CarroCreateRequest;
import com.github.lucascsalles.CP22.dto.CarroMapper;
import com.github.lucascsalles.CP22.dto.CarroResponse;
import com.github.lucascsalles.CP22.dto.CarroUpdateRequest;
import com.github.lucascsalles.CP22.model.Carro;
import com.github.lucascsalles.CP22.service.CarroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/${api.version}/carros")
public class CarroController {

    @Autowired
    private CarroService service;

    @Autowired
    private CarroMapper carroMapper;

    @PostMapping
    public ResponseEntity<CarroResponse> create (@Valid @RequestBody CarroCreateRequest dtoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carroMapper.toDto(service.createOrUpdate(carroMapper.toModel(dtoRequest))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroResponse> findById (@PathVariable Long id) {
        return service.findById(id).map(carro -> carroMapper.toDto(carro)).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CarroResponse>> findAll () {
        return ResponseEntity.ok(service.findAll().stream().map(carro -> carroMapper.toDto(carro)).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroResponse> update (@PathVariable Long id, @Valid @RequestBody CarroUpdateRequest dtoRequest) {
        if (service.findById(id).isPresent()) {
            Carro carroAtualizado = carroMapper.toModel(id, dtoRequest);
            return ResponseEntity.ok(carroMapper.toDto(service.createOrUpdate(carroAtualizado)));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
