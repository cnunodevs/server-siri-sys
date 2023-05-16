package com.senatic.siri.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.controller.common.GenericController;
import com.senatic.siri.model.dto.VoluntariosAprendicesFormadosColDTO;
import com.senatic.siri.model.entity.VoluntariosAprendicesFormadosCol;
import com.senatic.siri.model.mapper.VolAprFormColMapper;
import com.senatic.siri.service.common.GenericUseCases;

@RestController
@RequestMapping("api/v1/voluntarios-aprendices-formados-col")
public class VoluntariosAprendicesFormadosColController extends GenericController<VoluntariosAprendicesFormadosColDTO, VoluntariosAprendicesFormadosCol> {

    public VoluntariosAprendicesFormadosColController(GenericUseCases<VoluntariosAprendicesFormadosCol, UUID> service,
            VolAprFormColMapper mapper) {
        super(service, mapper);
    }

    
    
}
