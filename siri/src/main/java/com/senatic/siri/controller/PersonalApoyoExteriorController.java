package com.senatic.siri.controller;

import java.util.UUID;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.controller.common.FormularioController;
import com.senatic.siri.model.dto.PersonalApoyoExteriorDTO;
import com.senatic.siri.model.entity.PersonalApoyoExterior;
import com.senatic.siri.model.mapper.PersonalApoyoExteriorMapper;
import com.senatic.siri.service.common.GenericUseCases;


@Validated
@RestController
@RequestMapping("api/v1/personal-apoyo-ext")
public class PersonalApoyoExteriorController extends FormularioController<PersonalApoyoExteriorDTO, PersonalApoyoExterior> {
    
    public PersonalApoyoExteriorController(GenericUseCases<PersonalApoyoExterior, UUID> service, PersonalApoyoExteriorMapper mapper) {
        super(service, mapper);
    }

}
