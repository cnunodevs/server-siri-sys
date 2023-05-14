package com.senatic.siri.service.implementation;

import org.springframework.stereotype.Service;

import com.senatic.siri.model.entity.VoluntariosInternacionales;
import com.senatic.siri.repository.VoluntariosInternacionalesRepository;
import com.senatic.siri.service.common.GenericImplementation;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VoluntariosInternacionalesServiceImpl extends GenericImplementation<VoluntariosInternacionales> {

    public VoluntariosInternacionalesServiceImpl(VoluntariosInternacionalesRepository repository) {
        super(repository);
    }
    
    @Override
    public Boolean handleAlreadyExist(VoluntariosInternacionales t) {
        return repository.findById(t.getId()).isPresent();
    }

}