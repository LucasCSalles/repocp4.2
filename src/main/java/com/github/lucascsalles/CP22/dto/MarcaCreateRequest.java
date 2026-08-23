package com.github.lucascsalles.CP22.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MarcaCreateRequest {

    @NotNull
    private String nome;

    @NotNull
    private String descricao;

    @NotNull
    private Integer anoFundacao;

    private String carroMaisVendido;
}
