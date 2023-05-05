package com.senatic.siri.model.mapper;

import org.springframework.stereotype.Service;

import com.senatic.siri.model.dto.VoluntariosInstructoresFormadosColDTO;
import com.senatic.siri.model.entity.VoluntariosInstructoresFormadosCol;
import com.senatic.siri.model.mapper.common.GenericMapper;

@Service
public class VolInsFormColMapper implements GenericMapper<VoluntariosInstructoresFormadosCol, VoluntariosInstructoresFormadosColDTO> { 

    @Override
    public VoluntariosInstructoresFormadosColDTO pojoToDto(VoluntariosInstructoresFormadosCol p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pojoToDto'");
    }

    @Override
    public VoluntariosInstructoresFormadosCol dtoToPojo(VoluntariosInstructoresFormadosColDTO d) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dtoToPojo'");
    }
    
}
