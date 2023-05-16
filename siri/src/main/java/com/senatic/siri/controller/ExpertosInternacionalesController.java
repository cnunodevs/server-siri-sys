package com.senatic.siri.controller;


import java.util.UUID;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.controller.common.FormularioController;
import com.senatic.siri.model.dto.ExpertosInternacionalDTO;
import com.senatic.siri.model.entity.ExpertosInternacionales;
import com.senatic.siri.model.mapper.ExpertosInternacionalesMapper;
import com.senatic.siri.service.common.GenericUseCases;


@Validated
@RestController
@RequestMapping("api/v1/expertos-internacionales")
public class ExpertosInternacionalesController extends FormularioController<ExpertosInternacionalDTO, ExpertosInternacionales> {

    public ExpertosInternacionalesController(GenericUseCases<ExpertosInternacionales, UUID> service, ExpertosInternacionalesMapper mapper) {
        super(service, mapper);
    }

}
