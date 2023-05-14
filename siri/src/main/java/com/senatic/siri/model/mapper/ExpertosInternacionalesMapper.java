package com.senatic.siri.model.mapper;

import org.springframework.stereotype.Component;

import com.senatic.siri.model.dto.ExpertosInternacionalDTO;
import com.senatic.siri.model.entity.ExpertosInternacionales;
import com.senatic.siri.model.mapper.common.GenericMapper;

@Component
public class ExpertosInternacionalesMapper implements GenericMapper<ExpertosInternacionales, ExpertosInternacionalDTO> {

    @Override
    public ExpertosInternacionalDTO pojoToDto(ExpertosInternacionales pojo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pojoToDto'");
    }

    @Override
    public ExpertosInternacionales dtoToPojo(ExpertosInternacionalDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dtoToPojo'");
    }
    
}
