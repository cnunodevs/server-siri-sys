package com.senatic.siri.model.mapper;

import org.springframework.stereotype.Component;

import com.senatic.siri.model.dto.ExpertosInternacionalDTO;
import com.senatic.siri.model.entity.Asesor;
import com.senatic.siri.model.entity.Convenio;
import com.senatic.siri.model.entity.ExpertosInternacionales;
import com.senatic.siri.model.entity.Institucion;
import com.senatic.siri.model.entity.Pais;
import com.senatic.siri.model.mapper.common.GenericMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ExpertosInternacionalesMapper implements GenericMapper<ExpertosInternacionales, ExpertosInternacionalDTO> {

    private final PaisMapper paisMapper;
    private final InstitucionMapper institucionMapper;
    private final ConveniosMapper conveniosMapper;
    private final AsesorMapper asesorMapper;

    @Override
    public ExpertosInternacionalDTO pojoToDto(ExpertosInternacionales pojo) {
        return ExpertosInternacionalDTO.builder().id(pojo.getId())
                                                 .nombre(pojo.getNombre())
                                                 .cargo(pojo.getCargo())
                                                 .objeto(pojo.getObjeto())
                                                 .fechaInicio(pojo.getFechaInicio())
                                                 .fechaFinal(pojo.getFechaFinal())
                                                 .pais(paisMapper.pojoToDto(pojo.getPais()))
                                                 .institucion(institucionMapper.pojoToDto(pojo.getInstitucion()))
                                                 .asesor(asesorMapper.pojoToDto(pojo.getAsesor()))
                                                 .convenio(conveniosMapper.pojoToDto(pojo.getConvenio()))
                                                 .build();
    }

    @Override
    public ExpertosInternacionales dtoToPojo(ExpertosInternacionalDTO dto) {
        return ExpertosInternacionales.builder().nombre(dto.getNombre())
                                                .cargo(dto.getCargo())
                                                .objeto(dto.getObjeto())
                                                .fechaInicio(dto.getFechaInicio())
                                                .fechaFinal(dto.getFechaFinal())
                                                .pais(Pais.builder().id(dto.getPais().getId()).build())
                                                .institucion(Institucion.builder().id(dto.getInstitucion().getId()).build())
                                                .asesor(Asesor.builder().id(dto.getAsesor().getId()).build())
                                                .convenio(Convenio.builder().id(dto.getConvenio().getId()).build())
                                                .build();
    }
    
}
