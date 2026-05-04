package com.github.lucascsalles.CP22.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "carros")
@Entity
public class Carros {

    @Id
    private Long id;
    @Column(name = "nome_carro", length = 100, nullable = false)
    private String nome;
    @Column(name = "nome_marca", length = 100,nullable = false)
    private String marca; 
}
