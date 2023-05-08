package com.senatic.siri.service.common;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.senatic.siri.model.entity.common.FormularioEntity;

public interface FormularioService<T extends FormularioEntity, U>  extends GenericUseCases<T, U> {

    
}
