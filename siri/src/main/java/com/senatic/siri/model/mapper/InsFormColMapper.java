package com.senatic.siri.model.mapper;

import org.springframework.stereotype.Service;

import com.senatic.siri.model.dto.InstructoresFormadosColDTO;
import com.senatic.siri.model.entity.InstructoresFormadosCol;
import com.senatic.siri.model.mapper.common.GenericMapper;

@Service
public class InsFormColMapper implements GenericMapper<InstructoresFormadosCol, InstructoresFormadosColDTO> {

    @Override
    public InstructoresFormadosColDTO pojoToDto(InstructoresFormadosCol pojo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pojoToDto'");
    }

    @Override
    public InstructoresFormadosCol dtoToPojo(InstructoresFormadosColDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dtoToPojo'");
    }
    
}
