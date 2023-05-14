package com.senatic.siri.service.implementation;

import org.springframework.stereotype.Service;

import com.senatic.siri.model.entity.InstructoresFormadosCol;
import com.senatic.siri.repository.InstructoresFormadosColRepository;
import com.senatic.siri.service.common.GenericImplementation;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class InstructoresFormadosColServiceImpl extends GenericImplementation<InstructoresFormadosCol> {

    public InstructoresFormadosColServiceImpl(InstructoresFormadosColRepository instructoresFormadosColRepository) {
        super(instructoresFormadosColRepository);
    }
    
    @Override
    public Boolean handleAlreadyExist(InstructoresFormadosCol t) {
        return repository.findById(t.getId()).isPresent();
    }

}
