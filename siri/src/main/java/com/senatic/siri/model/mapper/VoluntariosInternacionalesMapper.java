package com.senatic.siri.model.mapper;

import org.springframework.stereotype.Component;

import com.senatic.siri.model.dto.VoluntariosInternacionalesDTO;
import com.senatic.siri.model.entity.VoluntariosInternacionales;
import com.senatic.siri.model.mapper.common.GenericMapper;


@Component
public class VoluntariosInternacionalesMapper implements GenericMapper<VoluntariosInternacionales, VoluntariosInternacionalesDTO> {

    @Override
    public VoluntariosInternacionalesDTO pojoToDto(VoluntariosInternacionales pojo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pojoToDto'");
    }

    @Override
    public VoluntariosInternacionales dtoToPojo(VoluntariosInternacionalesDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dtoToPojo'");
    }
    
}
