package com.senatic.siri.controller.common;

import java.util.UUID;


import com.senatic.siri.model.dto.common.FormularioDTO;
import com.senatic.siri.model.entity.common.FormularioEntity;
import com.senatic.siri.model.mapper.common.GenericMapper;
import com.senatic.siri.service.common.GenericUseCases;


// public class FormularioController<D extends FormularioDTO, P extends FormularioEntity, M extends FormularioMapper<P, D>, S extends FormularioService<P, UUID>> {
public class FormularioController<D extends FormularioDTO, P extends FormularioEntity> extends GenericController<D, P>{

    public FormularioController(GenericUseCases<P, UUID> service, GenericMapper<P, D> mapper) {
        super(service, mapper);
    }

}
