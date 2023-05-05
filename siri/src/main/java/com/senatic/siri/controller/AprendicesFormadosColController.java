package com.senatic.siri.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.controller.common.FormularioController;
import com.senatic.siri.model.dto.AprendicesFormadosColDTO;
import com.senatic.siri.model.entity.AprendicesFormadosCol;
import com.senatic.siri.model.mapper.AprFormColMapper;
import com.senatic.siri.service.AprendicesFormadosColService;



@Validated
@RestController
@RequestMapping("api/v1/aprendices-formados-col")
public class AprendicesFormadosColController extends FormularioController<AprendicesFormadosColDTO, AprendicesFormadosCol, AprFormColMapper, AprendicesFormadosColService>{

    public AprendicesFormadosColController(AprFormColMapper mapper, AprendicesFormadosColService service){
        super(service, mapper);
    }
    
}
