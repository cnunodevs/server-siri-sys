package com.senatic.siri.model.mapper;

import org.springframework.stereotype.Component;

import com.senatic.siri.model.dto.PersonalApoyoExteriorDTO;
import com.senatic.siri.model.entity.Asesor;
import com.senatic.siri.model.entity.Institucion;
import com.senatic.siri.model.entity.PersonalApoyoExterior;
import com.senatic.siri.model.mapper.common.GenericMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PersonalApoyoExteriorMapper implements GenericMapper<PersonalApoyoExterior, PersonalApoyoExteriorDTO> {

    private final InstitucionMapper institucionMapper;
    private final AsesorMapper asesorMapper;

    @Override
    public PersonalApoyoExteriorDTO pojoToDto(PersonalApoyoExterior pojo) {
        return PersonalApoyoExteriorDTO.builder().id(pojo.getId())
                                                 .objeto(pojo.getObjeto())
                                                 .nombre(pojo.getNombre())
                                                 .cargo(pojo.getCargo())
                                                 .dependenciaSena(pojo.getDependenciaSena())
                                                 .fechaInicio(pojo.getFechaInicio())
                                                 .fechaFinal(pojo.getFechaFinal())
                                                 .asesor(asesorMapper.pojoToDto(pojo.getAsesor()))
                                                 .institucion(institucionMapper.pojoToDto(pojo.getInstitucion()))
                                                 .build();
    }

    @Override
    public PersonalApoyoExterior dtoToPojo(PersonalApoyoExteriorDTO dto) {
        return PersonalApoyoExterior.builder().objeto(dto.getObjeto())
                                            .nombre(dto.getNombre())
                                            .cargo(dto.getCargo())
                                            .dependenciaSena(dto.getDependenciaSena())
                                            .fechaInicio(dto.getFechaInicio())
                                            .fechaFinal(dto.getFechaFinal())
                                            .institucion(Institucion.builder().id(dto.getInstitucion().getId()).build())
                                            .asesor(Asesor.builder().id(dto.getAsesor().getId()).build())
                                            .build();
    }
    
}
