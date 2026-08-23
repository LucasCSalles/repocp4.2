package com.github.lucascsalles.CP22.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.lucascsalles.CP22.model.Carro;
import com.github.lucascsalles.CP22.repository.CarroRepository;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    public Carro createOrUpdate(Carro carro) {
        return repository.save(carro);
    }

    public List<Carro> findAll() {
        return repository.findAll();
    }

    public Optional<Carro> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
