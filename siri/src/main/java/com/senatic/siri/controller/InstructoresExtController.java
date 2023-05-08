package com.senatic.siri.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.controller.common.FormularioController;
import com.senatic.siri.model.dto.InstructoresExtDTO;
import com.senatic.siri.model.entity.InstructoresExt;
import com.senatic.siri.model.mapper.InstructoresExtMapper;
import com.senatic.siri.service.InstructoresExtService;


@Validated
@RestController
@RequestMapping("api/v1/instructores-ext")
public class InstructoresExtController extends FormularioController<InstructoresExtDTO, InstructoresExt> {

    public InstructoresExtController(InstructoresExtService service, InstructoresExtMapper mapper) {
        super(service, mapper);
    }

}
