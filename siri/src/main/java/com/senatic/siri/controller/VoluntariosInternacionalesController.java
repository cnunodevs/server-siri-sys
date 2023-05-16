package com.senatic.siri.controller;

import java.util.UUID;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.controller.common.FormularioController;
import com.senatic.siri.model.dto.VoluntariosInternacionalesDTO;
import com.senatic.siri.model.entity.VoluntariosInternacionales;
import com.senatic.siri.model.mapper.VoluntariosInternacionalesMapper;
import com.senatic.siri.service.common.GenericUseCases;

@Validated
@RestController
@RequestMapping("api/v1/voluntarios-internacionales")
public class VoluntariosInternacionalesController extends FormularioController<VoluntariosInternacionalesDTO, VoluntariosInternacionales> {

    public VoluntariosInternacionalesController(GenericUseCases<VoluntariosInternacionales, UUID> service, VoluntariosInternacionalesMapper mapper) {
        super(service, mapper);
    }

}
