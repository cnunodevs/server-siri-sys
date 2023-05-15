package com.senatic.siri.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.controller.common.GenericController;
import com.senatic.siri.model.dto.PaisDTO;
import com.senatic.siri.model.entity.Pais;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/pais")
public class PaisController extends GenericController<PaisDTO, Pais> {
    
    

}
