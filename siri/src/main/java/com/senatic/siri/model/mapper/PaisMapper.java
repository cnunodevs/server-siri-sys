package com.senatic.siri.model.mapper;

import org.springframework.stereotype.Component;

import com.senatic.siri.model.dto.PaisDTO;
import com.senatic.siri.model.entity.Pais;
import com.senatic.siri.model.mapper.common.GenericMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaisMapper implements GenericMapper<Pais, PaisDTO> {

    @Override
    public PaisDTO pojoToDto(Pais pojo) {
        return PaisDTO.builder().id(pojo.getId())
                .nombre(pojo.getNombre())
                .abreviatura(pojo.getAbreviatura())
                .build();
    }

    @Override
    public Pais dtoToPojo(PaisDTO dto) {
        return Pais.builder().nombre(dto.getNombre())
                             .abreviatura(dto.getAbreviatura())
                             .build();
    }

}
