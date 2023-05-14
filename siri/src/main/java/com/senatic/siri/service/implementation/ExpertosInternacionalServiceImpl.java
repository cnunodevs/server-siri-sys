package com.senatic.siri.service.implementation;

import org.springframework.stereotype.Service;

import com.senatic.siri.model.entity.ExpertosInternacionales;
import com.senatic.siri.repository.ExpertosInternacionalesRepository;
import com.senatic.siri.service.common.GenericImplementation;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ExpertosInternacionalServiceImpl extends GenericImplementation<ExpertosInternacionales> {

    public ExpertosInternacionalServiceImpl(ExpertosInternacionalesRepository repository) {
        super(repository);
    }

    @Override
    public Boolean handleAlreadyExist(ExpertosInternacionales t) {
        return repository.findById(t.getId()).isPresent();
    }
    
}
