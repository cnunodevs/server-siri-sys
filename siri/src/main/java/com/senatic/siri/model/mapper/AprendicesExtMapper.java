package com.senatic.siri.model.mapper;

import org.springframework.stereotype.Component;

import com.senatic.siri.model.dto.AprendicesExtDTO;
import com.senatic.siri.model.entity.AprendicesExt;
import com.senatic.siri.model.entity.Convenio;
import com.senatic.siri.model.entity.Institucion;
import com.senatic.siri.model.entity.Pais;
import com.senatic.siri.model.mapper.common.GenericMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AprendicesExtMapper implements GenericMapper<AprendicesExt, AprendicesExtDTO> {

    /* 
     * TODO: hacer el dto para pais institucion convenio y asesor y su respectivo mapper
     */
    private final PaisMapper paisMapper;
    private final InstitucionMapper institucionMapper;
    private final ConveniosMapper conveniosMapper;


    @Override
    public AprendicesExtDTO pojoToDto(AprendicesExt pojo) {
        return AprendicesExtDTO.builder().id(pojo.getId())
                                         .objetoFormacion(pojo.getObjetoFormacion())
                                         .programaFormacion(pojo.getProgramaFormacion())
                                         .nombre(pojo.getNombre())
                                         .fechaInicio(pojo.getFechaInicio())
                                         .fechaFinal(pojo.getFechaFinal())
                                         .pais(paisMapper.pojoToDto(pojo.getPais()))
                                         .institucion(institucionMapper.pojoToDto(pojo.getInstitucion()))
                                         .convenio(conveniosMapper.pojoToDto(pojo.getConvenio()))
                                         .build();
    }

    @Override
    public AprendicesExt dtoToPojo(AprendicesExtDTO dto) {
        return AprendicesExt.builder().objetoFormacion(dto.getObjetoFormacion())
                                      .programaFormacion(dto.getProgramaFormacion())
                                      .nombre(dto.getNombre())
                                      .fechaInicio(dto.getFechaInicio())
                                      .fechaFinal(dto.getFechaFinal())
                                      .pais(Pais.builder().id(dto.getPais().getId()).build())
                                      .institucion(Institucion.builder().id(dto.getInstitucion().getId()).build())
                                      .convenio(Convenio.builder().id(dto.getConvenio().getId()).build())
                                      .build();
    }
    
}
