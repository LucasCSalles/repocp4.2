package com.github.lucascsalles.CP22.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.github.lucascsalles.CP22.model.Marca;

@Component
public class MarcaMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public MarcaResponse toDto(Marca marca) {
        return modelMapper.map(marca, MarcaResponse.class);
    }

    public Marca toModel(MarcaCreateRequest dto) {
        return modelMapper.map(dto, Marca.class);
    }

    public Marca toModel(Long id, MarcaUpdateRequest dto) {
        Marca marca = modelMapper.map(dto, Marca.class);
        marca.setId(id);
        return marca;
    }
}
