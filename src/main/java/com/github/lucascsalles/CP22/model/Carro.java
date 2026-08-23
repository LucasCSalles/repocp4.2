package com.github.lucascsalles.CP22.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "carros")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_carros", length = 100, nullable = false)
    private String nome;

    @Column(name = "nome_marcas", length = 100, nullable = false)
    private String marca;

    private String modelo;
    private int ano;
}
