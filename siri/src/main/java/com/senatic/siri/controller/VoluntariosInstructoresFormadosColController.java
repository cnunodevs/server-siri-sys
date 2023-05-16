package com.senatic.siri.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.controller.common.GenericController;
import com.senatic.siri.model.dto.VoluntariosInstructoresFormadosColDTO;
import com.senatic.siri.model.entity.VoluntariosInstructoresFormadosCol;
import com.senatic.siri.model.mapper.VolInsFormColMapper;
import com.senatic.siri.service.common.GenericUseCases;

@RestController
@RequestMapping("api/v1/voluntarios-instructores-formados-col")
public class VoluntariosInstructoresFormadosColController extends GenericController<VoluntariosInstructoresFormadosColDTO, VoluntariosInstructoresFormadosCol> {

    public VoluntariosInstructoresFormadosColController(
            GenericUseCases<VoluntariosInstructoresFormadosCol, UUID> service,
            VolInsFormColMapper mapper) {
        super(service, mapper);
    }

    

}
