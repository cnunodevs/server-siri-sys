package com.senatic.siri.service.implementation;

import org.springframework.stereotype.Service;

import com.senatic.siri.model.entity.PersonalApoyoExterior;
import com.senatic.siri.repository.PersonalApoyoExteriorRepository;
import com.senatic.siri.service.common.GenericImplementation;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PersonalApoyoExteriorServiceImpl extends GenericImplementation<PersonalApoyoExterior> {

    public PersonalApoyoExteriorServiceImpl(PersonalApoyoExteriorRepository repository) {
        super(repository);
    }

    @Override
    public Boolean handleAlreadyExist(PersonalApoyoExterior t) {
        return repository.findById(t.getId()).isPresent();
    }
    
}
