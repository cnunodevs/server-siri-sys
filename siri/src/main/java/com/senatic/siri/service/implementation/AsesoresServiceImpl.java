package com.senatic.siri.service.implementation;

import org.springframework.stereotype.Service;

import com.senatic.siri.model.entity.Asesor;
import com.senatic.siri.repository.common.AsesoresRepository;
import com.senatic.siri.service.common.GenericImplementation;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AsesoresServiceImpl extends GenericImplementation<Asesor> {

    public AsesoresServiceImpl(AsesoresRepository repository) {
        super(repository);
    }
    
    @Override
    public Boolean handleAlreadyExist(Asesor t) {
        return repository.findById(t.getId()).isPresent();
    }

}
