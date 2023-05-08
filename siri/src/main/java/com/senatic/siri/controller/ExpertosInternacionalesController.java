package com.senatic.siri.controller;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.controller.common.FormularioController;
import com.senatic.siri.model.dto.ExpertosInternacionalDTO;
import com.senatic.siri.model.entity.ExpertosInternacionales;
import com.senatic.siri.model.mapper.ExpertosInternacionalesMapper;
import com.senatic.siri.service.ExpertosInternacionalService;


@Validated
@RestController
@RequestMapping("api/v1/expertos-internacionales")
public class ExpertosInternacionalesController extends FormularioController<ExpertosInternacionalDTO, ExpertosInternacionales> {

    public ExpertosInternacionalesController(ExpertosInternacionalService service, ExpertosInternacionalesMapper mapper) {
        super(service, mapper);
    }

}
