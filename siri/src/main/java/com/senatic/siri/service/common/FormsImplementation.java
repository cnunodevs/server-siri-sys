package com.senatic.siri.service.common;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senatic.siri.model.entity.common.FormularioEntity;

public class FormsImplementation <T extends FormularioEntity> extends GenericImplementation<T> {

    public FormsImplementation(JpaRepository<T, UUID> repository) {
        super(repository);
    }
    
}
