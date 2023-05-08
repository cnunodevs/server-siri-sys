package com.senatic.siri.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.controller.common.FormularioController;
import com.senatic.siri.model.dto.PersonalApoyoExteriorDTO;
import com.senatic.siri.model.entity.PersonalApoyoExterior;
import com.senatic.siri.model.mapper.PersonalApoyoExteriorMapper;
import com.senatic.siri.service.PersonalApoyoExteriorService;


@Validated
@RestController
@RequestMapping("api/v1/personal-apoyo-ext")
public class PersonalApoyoExteriorController extends FormularioController<PersonalApoyoExteriorDTO, PersonalApoyoExterior> {
    
    public PersonalApoyoExteriorController(PersonalApoyoExteriorService service, PersonalApoyoExteriorMapper mapper) {
        super(service, mapper);
    }

}
