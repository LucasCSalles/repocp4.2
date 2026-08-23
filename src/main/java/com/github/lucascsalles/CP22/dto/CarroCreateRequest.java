package com.github.lucascsalles.CP22.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CarroCreateRequest {

    @NotNull
    private String nome;

    @NotNull
    private String marca;

    @NotNull
    private String modelo;

    @NotNull
    private Integer ano;
}
