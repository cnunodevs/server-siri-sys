package com.senatic.siri.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.controller.common.GenericController;
import com.senatic.siri.model.dto.ConvenioDTO;
import com.senatic.siri.model.entity.Convenio;
import com.senatic.siri.model.mapper.ConveniosMapper;
import com.senatic.siri.service.common.GenericUseCases;

@RestController
@RequestMapping("api/v1/convenios")
public class ConveniosController extends GenericController<ConvenioDTO, Convenio> {

    public ConveniosController(GenericUseCases<Convenio, UUID> service, ConveniosMapper mapper) {
        super(service, mapper);
    }

}
