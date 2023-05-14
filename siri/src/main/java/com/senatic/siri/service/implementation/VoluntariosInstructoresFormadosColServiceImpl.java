package com.senatic.siri.service.implementation;

import org.springframework.stereotype.Service;

import com.senatic.siri.model.entity.VoluntariosInstructoresFormadosCol;
import com.senatic.siri.repository.VoluntariosInstructoresFormadosColRepository;
import com.senatic.siri.service.common.GenericImplementation;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VoluntariosInstructoresFormadosColServiceImpl extends GenericImplementation<VoluntariosInstructoresFormadosCol> {

    public VoluntariosInstructoresFormadosColServiceImpl(VoluntariosInstructoresFormadosColRepository voluntariosInstructoresFormadosColRepository) {
        super(voluntariosInstructoresFormadosColRepository);
    }
    
}
