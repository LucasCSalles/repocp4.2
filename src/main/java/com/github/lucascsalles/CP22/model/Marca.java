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
@Table(name = "marcas")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_marca", length = 100, nullable = false)
    private String nome;

    @Column(name = "descricao_marca", length = 500, nullable = false)
    private String descricao;

    private int anoFundacao;
    private String carroMaisVendido;
}

