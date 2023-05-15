package com.senatic.siri.model.mapper;

import org.springframework.stereotype.Component;

import com.senatic.siri.model.dto.InstitucionDTO;
import com.senatic.siri.model.entity.Institucion;
import com.senatic.siri.model.entity.Pais;
import com.senatic.siri.model.entity.Pais.Ciudad;
import com.senatic.siri.model.mapper.PaisMapper.CiudadMapper;
import com.senatic.siri.model.mapper.common.GenericMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InstitucionMapper implements GenericMapper<Institucion, InstitucionDTO> {

    private final PaisMapper paisMapper;
    private final CiudadMapper ciudadMapper;

    @Override
    public InstitucionDTO pojoToDto(Institucion pojo) {
        return InstitucionDTO.builder().id(pojo.getId())
                                        .codigo(pojo.getCodigo())
                                        .nombre(pojo.getNombre())
                                        .tipo(pojo.getTipo())
                                        .pais(paisMapper.pojoToDto(pojo.getPais()))
                                        .ciudad(ciudadMapper.pojoToDto(pojo.getCiudad()))
                                        .build();
    }

    @Override
    public Institucion dtoToPojo(InstitucionDTO dto) {
        return Institucion.builder().codigo(dto.getCodigo())
                                    .nombre(dto.getNombre())
                                    .tipo(dto.getTipo())
                                    .pais(Pais.builder().id(dto.getPais().getId()).build())
                                    .ciudad(Ciudad.builder().id(dto.getCiudad().getId()).build())
                                    .build();
    }
    
}
