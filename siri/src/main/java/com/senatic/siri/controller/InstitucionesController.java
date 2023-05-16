package com.senatic.siri.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.controller.common.GenericController;
import com.senatic.siri.model.dto.InstitucionDTO;
import com.senatic.siri.model.entity.Institucion;
import com.senatic.siri.model.mapper.InstitucionMapper;
import com.senatic.siri.service.common.GenericUseCases;

@RestController
@RequestMapping("api/v1/instituciones")
public class InstitucionesController extends GenericController<InstitucionDTO, Institucion> {

    public InstitucionesController(GenericUseCases<Institucion, UUID> service,
            InstitucionMapper mapper) {
        super(service, mapper);
    }
    
    

}
