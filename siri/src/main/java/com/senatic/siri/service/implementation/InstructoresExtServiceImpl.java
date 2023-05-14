package com.senatic.siri.service.implementation;

import org.springframework.stereotype.Service;

import com.senatic.siri.model.entity.InstructoresExt;
import com.senatic.siri.repository.InstructoresExtRepository;
import com.senatic.siri.service.common.GenericImplementation;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class InstructoresExtServiceImpl extends GenericImplementation<InstructoresExt> {

    public InstructoresExtServiceImpl(InstructoresExtRepository repository) {
        super(repository);
    }

    @Override
    public Boolean handleAlreadyExist(InstructoresExt t) {
        return repository.findById(t.getId()).isPresent();
    }

}
