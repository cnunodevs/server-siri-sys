package com.senatic.siri.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.controller.common.GenericController;
import com.senatic.siri.model.dto.AsesorDTO;
import com.senatic.siri.model.entity.Asesor;
import com.senatic.siri.model.mapper.AsesorMapper;
import com.senatic.siri.service.common.GenericUseCases;

@RestController
@RequestMapping("api/v1/asesores")
public class AsesorerController extends GenericController<AsesorDTO, Asesor> {

    public AsesorerController(GenericUseCases<Asesor, UUID> service, AsesorMapper mapper) {
        super(service, mapper);
    }
    
    

}
