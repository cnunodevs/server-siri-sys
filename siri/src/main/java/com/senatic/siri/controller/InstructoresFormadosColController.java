package com.senatic.siri.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.controller.common.FormularioController;
import com.senatic.siri.model.dto.InstructoresFormadosColDTO;
import com.senatic.siri.model.entity.InstructoresFormadosCol;
import com.senatic.siri.model.mapper.InsFormColMapper;
import com.senatic.siri.service.common.GenericUseCases;

@RestController
@RequestMapping("api/v1/instructores-formados-col")
public class InstructoresFormadosColController extends FormularioController<InstructoresFormadosColDTO, InstructoresFormadosCol> {

    public InstructoresFormadosColController(GenericUseCases<InstructoresFormadosCol, UUID> service,InsFormColMapper mapper) {
        super(service, mapper);
    }
    

    
}
