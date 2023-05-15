package com.senatic.siri.model.mapper;

import org.springframework.stereotype.Component;

import com.senatic.siri.model.dto.PaisDTO;
import com.senatic.siri.model.dto.PaisDTO.CiudadDTO;
import com.senatic.siri.model.entity.Pais;
import com.senatic.siri.model.entity.Pais.Ciudad;
import com.senatic.siri.model.mapper.common.GenericMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaisMapper implements GenericMapper<Pais, PaisDTO> {

    private final CiudadMapper ciudadMapper;

    @Override
    public PaisDTO pojoToDto(Pais pojo) {
        return PaisDTO.builder().id(pojo.getId())
                                .nombre(pojo.getNombre())
                                .ciudades(pojo.getCiudades().stream().map(ciudadMapper::pojoToDto).toList())
                                .build();
    }

    @Override
    public Pais dtoToPojo(PaisDTO dto) {
        return Pais.builder().nombre(dto.getNombre())
                              .ciudades(dto.getCiudades().stream().map(ciudadMapper::dtoToPojo).toList())
                              .build();
    }

    @Component
    @RequiredArgsConstructor
    public static class CiudadMapper implements GenericMapper<Ciudad, CiudadDTO>{

        @Override
        public CiudadDTO pojoToDto(Ciudad pojo) {
            return CiudadDTO.builder().id(pojo.getId())
                                      .nombre(pojo.getNombre())
                                      .idPais(pojo.getPais().getId())
                                      .build();
        }

        @Override
        public Ciudad dtoToPojo(CiudadDTO dto) {
            return Ciudad.builder().nombre(dto.getNombre())
                                    .pais(Pais.builder().id(dto.getIdPais()).build())
                                    .build();
        }

    }
    
}
