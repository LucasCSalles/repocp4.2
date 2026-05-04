package com.github.lucascsalles.CP22.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.lucascsalles.CP22.model.Carros;

@Repository
public interface CarrosRepository extends JpaRepository<Carros,Long>{

}
