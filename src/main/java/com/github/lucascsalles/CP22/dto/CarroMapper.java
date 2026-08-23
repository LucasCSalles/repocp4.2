package com.github.lucascsalles.CP22.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.github.lucascsalles.CP22.model.Carro;

@Component
public class CarroMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public CarroResponse toDto(Carro carro) {
        return modelMapper.map(carro, CarroResponse.class);
    }

    public Carro toModel(CarroCreateRequest dto) {
        return modelMapper.map(dto, Carro.class);
    }

    public Carro toModel(Long id, CarroUpdateRequest dto) {
        Carro carro = modelMapper.map(dto, Carro.class);
        carro.setId(id);
        return carro;
    }
}
