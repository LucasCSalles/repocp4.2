package com.github.lucascsalles.CP22.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.lucascsalles.CP22.model.Marca;
import com.github.lucascsalles.CP22.repository.MarcaRepository;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository repository;

    public Marca createOrUpdate(Marca marca) {
        return repository.save(marca);
    }

    public List<Marca> findAll() {
        return repository.findAll();
    }

    public Optional<Marca> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
