package com.senatic.siri.service.implementation;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senatic.siri.model.entity.Institucion;
import com.senatic.siri.repository.common.InstitucionesRepository;
import com.senatic.siri.service.common.GenericImplementation;

public class InstitucionServiceImpl extends GenericImplementation<Institucion> {

    public InstitucionServiceImpl(InstitucionesRepository repository) {
        super(repository);
    }
    
    
    
}
