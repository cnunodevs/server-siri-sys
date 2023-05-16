package com.senatic.siri.controller;

import java.util.UUID;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.controller.common.FormularioController;
import com.senatic.siri.model.dto.AprendicesFormadosColDTO;
import com.senatic.siri.model.entity.AprendicesFormadosCol;
import com.senatic.siri.model.mapper.AprFormColMapper;
import com.senatic.siri.service.common.GenericUseCases;



@Validated
@RestController
@RequestMapping("api/v1/aprendices-formados-col")
public class AprendicesFormadosColController extends FormularioController<AprendicesFormadosColDTO, AprendicesFormadosCol>{

    public AprendicesFormadosColController(AprFormColMapper mapper, GenericUseCases<AprendicesFormadosCol, UUID> service){
        super(service, mapper);
    }
    
}
