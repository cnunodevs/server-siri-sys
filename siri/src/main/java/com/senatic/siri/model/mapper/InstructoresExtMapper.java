package com.senatic.siri.model.mapper;

import org.springframework.stereotype.Component;

import com.senatic.siri.model.dto.InstructoresExtDTO;
import com.senatic.siri.model.entity.Convenio;
import com.senatic.siri.model.entity.Institucion;
import com.senatic.siri.model.entity.InstructoresExt;
import com.senatic.siri.model.entity.Pais;
import com.senatic.siri.model.mapper.common.GenericMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InstructoresExtMapper implements GenericMapper<InstructoresExt, InstructoresExtDTO> {

    private final PaisMapper paisMapper;
    private final InstitucionMapper institucionMapper;
    private final ConveniosMapper conveniosMapper;

    @Override
    public InstructoresExtDTO pojoToDto(InstructoresExt pojo) {
        return InstructoresExtDTO.builder().no(pojo.getNo())
                                           .nombre(pojo.getNombre())
                                           .objeto(pojo.getObjeto())
                                           .coordinacionAcademica(pojo.getCoordinacionAcademica())
                                           .contratista(pojo.getContratista())
                                           .fechaInicio(pojo.getFechaInicio())
                                           .fechaFinal(pojo.getFechaFinal())
                                           .pais(paisMapper.pojoToDto(pojo.getPais()))
                                           .institucion(institucionMapper.pojoToDto(pojo.getInstitucion()))
                                           .convenio(conveniosMapper.pojoToDto(pojo.getConvenio()))
                                           .build();
    }

    @Override
    public InstructoresExt dtoToPojo(InstructoresExtDTO dto) {
        return InstructoresExt.builder().nombre(dto.getNombre())
                                        .objeto(dto.getObjeto())
                                        .coordinacionAcademica(dto.getCoordinacionAcademica())
                                        .contratista(dto.getContratista())
                                        .fechaInicio(dto.getFechaInicio())
                                        .fechaFinal(dto.getFechaFinal())
                                        .pais(Pais.builder().id(dto.getPais().getId()).build())
                                        .institucion(Institucion.builder().id(dto.getInstitucion().getId()).build())
                                        .convenio(Convenio.builder().id(dto.getConvenio().getId()).build())
                                        .build();

    }
    
}
