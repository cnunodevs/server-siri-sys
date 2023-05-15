package com.senatic.siri.service.implementation;

import com.senatic.siri.model.entity.Convenio;
import com.senatic.siri.repository.common.ConveniosRepository;
import com.senatic.siri.service.common.GenericImplementation;

public class ConvenioServiceImpl extends GenericImplementation<Convenio> {

    public ConvenioServiceImpl(ConveniosRepository repository) {
        super(repository);
    }

    @Override
    public Boolean handleAlreadyExist(Convenio t) {
        return repository.findById(t.getId()).isPresent();
    }
    
}
