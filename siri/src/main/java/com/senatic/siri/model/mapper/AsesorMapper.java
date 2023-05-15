package com.senatic.siri.model.mapper;

import com.senatic.siri.model.dto.AsesorDTO;
import com.senatic.siri.model.entity.Asesor;
import com.senatic.siri.model.mapper.common.GenericMapper;

public class AsesorMapper implements GenericMapper<Asesor, AsesorDTO> {

    @Override
    public AsesorDTO pojoToDto(Asesor pojo) {
        return AsesorDTO.builder().id(pojo.getId())
                                  .nombre(pojo.getNombre())
                                  .apellido(pojo.getApellido())
                                  .profesion(pojo.getProfesion())
                                  .detalleAsesoramiento(pojo.getDetalleAsesoramiento())
                                  .build();
    }

    @Override
    public Asesor dtoToPojo(AsesorDTO dto) {
        return Asesor.builder().nombre(dto.getNombre())
                                .apellido(dto.getApellido())
                                .profesion(dto.getProfesion())
                                .detalleAsesoramiento(dto.getDetalleAsesoramiento())
                                .build();
    }
    
}
