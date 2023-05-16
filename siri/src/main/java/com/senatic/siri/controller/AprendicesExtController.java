package com.senatic.siri.controller;

import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.controller.common.FormularioController;
import com.senatic.siri.model.dto.AprendicesExtDTO;
import com.senatic.siri.model.entity.AprendicesExt;
import com.senatic.siri.model.mapper.AprendicesExtMapper;
import com.senatic.siri.service.common.GenericUseCases;

import java.util.UUID;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@RestController
@RequestMapping("api/v1/aprendices-ext")
public class AprendicesExtController extends FormularioController<AprendicesExtDTO, AprendicesExt> {

    public AprendicesExtController(AprendicesExtMapper mapper, GenericUseCases<AprendicesExt, UUID> service){
        super(service, mapper);
    }
}
