package com.github.lucascsalles.CP22.dto;

import lombok.Data;

@Data
public class MarcaResponse {
    private Long id;
    private String nome;
    private String descricao;
    private Integer anoFundacao;
    private String carroMaisVendido;
}
