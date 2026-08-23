package com.github.lucascsalles.CP22.dto;

import lombok.Data;

@Data
public class CarroUpdateRequest {
    private String nome;
    private String marca;
    private String modelo;
    private Integer ano;
}
