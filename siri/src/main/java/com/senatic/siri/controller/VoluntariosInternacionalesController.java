package com.senatic.siri.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.controller.common.FormularioController;
import com.senatic.siri.model.dto.VoluntariosInternacionalesDTO;
import com.senatic.siri.model.entity.VoluntariosInternacionales;
import com.senatic.siri.model.mapper.VoluntariosInternacionalesMapper;
import com.senatic.siri.service.VoluntariosInternacionalesService;

@Validated
@RestController
@RequestMapping("api/v1/voluntarios-internacionales")
public class VoluntariosInternacionalesController extends FormularioController<VoluntariosInternacionalesDTO, VoluntariosInternacionales> {

    public VoluntariosInternacionalesController(VoluntariosInternacionalesService service, VoluntariosInternacionalesMapper mapper) {
        super(service, mapper);
    }

}
