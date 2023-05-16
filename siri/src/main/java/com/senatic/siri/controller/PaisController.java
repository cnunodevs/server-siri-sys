package com.senatic.siri.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.controller.common.GenericController;
import com.senatic.siri.model.dto.PaisDTO;
import com.senatic.siri.model.entity.Pais;
import com.senatic.siri.model.mapper.PaisMapper;
import com.senatic.siri.service.common.GenericUseCases;

@RestController
@RequestMapping("api/v1/pais")
public class PaisController extends GenericController<PaisDTO, Pais> {

    public PaisController(GenericUseCases<Pais, UUID> service, PaisMapper mapper) {
        super(service, mapper);
    }
    

}
