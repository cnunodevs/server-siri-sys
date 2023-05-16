package com.senatic.siri.controller;

import java.util.UUID;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.controller.common.FormularioController;
import com.senatic.siri.model.dto.InstructoresExtDTO;
import com.senatic.siri.model.entity.InstructoresExt;
import com.senatic.siri.model.mapper.InstructoresExtMapper;
import com.senatic.siri.service.common.GenericUseCases;


@Validated
@RestController
@RequestMapping("api/v1/instructores-ext")
public class InstructoresExtController extends FormularioController<InstructoresExtDTO, InstructoresExt> {

    public InstructoresExtController(GenericUseCases<InstructoresExt, UUID> service, InstructoresExtMapper mapper) {
        super(service, mapper);
    }

}
