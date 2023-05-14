package com.senatic.siri.service.implementation;

import org.springframework.stereotype.Service;

import com.senatic.siri.model.entity.AprendicesExt;
import com.senatic.siri.repository.AprendicesExtRepository;
import com.senatic.siri.service.common.GenericImplementation;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AprendicesExtServiceImpl extends GenericImplementation<AprendicesExt> {

    public AprendicesExtServiceImpl(AprendicesExtRepository repository) {
        super(repository);
    }

    @Override
    public Boolean handleAlreadyExist(AprendicesExt t) {
        return repository.findById(t.getId()).isPresent();
    }
    
}
