package com.senatic.siri.model.mapper;

import org.springframework.stereotype.Component;

import com.senatic.siri.model.dto.VoluntariosInternacionalesDTO;
import com.senatic.siri.model.entity.Asesor;
import com.senatic.siri.model.entity.Convenio;
import com.senatic.siri.model.entity.Pais;
import com.senatic.siri.model.entity.VoluntariosInternacionales;
import com.senatic.siri.model.mapper.common.GenericMapper;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class VoluntariosInternacionalesMapper implements GenericMapper<VoluntariosInternacionales, VoluntariosInternacionalesDTO> {


    private final PaisMapper paisMapper;
    private final ConveniosMapper conveniosMapper;
    private final AsesorMapper asesorMapper;

    @Override
    public VoluntariosInternacionalesDTO pojoToDto(VoluntariosInternacionales pojo) {
        return VoluntariosInternacionalesDTO.builder().id(pojo.getId())
                                                      .nombre(pojo.getNombre())
                                                      .objeto(pojo.getObjeto())
                                                      .centroFormacion(pojo.getCentroFormacion())
                                                      .fechaInicio(pojo.getFechaInicio())
                                                      .fechaFinal(pojo.getFechaFinal())
                                                      .pais(paisMapper.pojoToDto(pojo.getPais()))
                                                      .asesor(asesorMapper.pojoToDto(pojo.getAsesor()))
                                                      .convenio(conveniosMapper.pojoToDto(pojo.getConvenio()))
                                                      .build();

    }

    @Override
    public VoluntariosInternacionales dtoToPojo(VoluntariosInternacionalesDTO dto) {
        return VoluntariosInternacionales.builder().nombre(dto.getNombre())
                                                   .objeto(dto.getObjeto())
                                                   .centroFormacion(dto.getCentroFormacion())
                                                   .fechaInicio(dto.getFechaInicio())
                                                   .fechaFinal(dto.getFechaFinal())
                                                   .pais(Pais.builder().id(dto.getPais().getId()).build())
                                                   .asesor(Asesor.builder().id(dto.getAsesor().getId()).build())
                                                   .convenio(Convenio.builder().id(dto.getConvenio().getId()).build())
                                                   .build();
    }
    
}
