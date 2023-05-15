package com.senatic.siri.model.mapper;

import com.senatic.siri.model.dto.ConvenioDTO;
import com.senatic.siri.model.entity.Convenio;
import com.senatic.siri.model.mapper.common.GenericMapper;

public class ConveniosMapper implements GenericMapper<Convenio, ConvenioDTO> {

    @Override
    public ConvenioDTO pojoToDto(Convenio pojo) {
        return ConvenioDTO.builder().id(pojo.getId())
                                    .codigo(pojo.getCodigo())
                                    .fechaInicial(pojo.getFechaInicial())
                                    .fechaFinal(pojo.getFechaFinal())
                                    .detalleConvenio(pojo.getDetalleConvenio())
                                    .build();
    }

    @Override
    public Convenio dtoToPojo(ConvenioDTO dto) {
        return Convenio.builder().codigo(dto.getCodigo())
                                .fechaInicial(dto.getFechaInicial())
                                .fechaFinal(dto.getFechaFinal())
                                .detalleConvenio(dto.getDetalleConvenio())
                                .build();
    }
    
}
