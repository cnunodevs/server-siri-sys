package com.senatic.siri.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.model.dto.PersonalApoyoExteriorDTO;
import com.senatic.siri.model.entity.PersonalApoyoExterior;
import com.senatic.siri.model.mapper.PersonalApoyoExteriorMapper;
import com.senatic.siri.service.PersonalApoyoExteriorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/personal-apoyo-ext")
public class PersonalApoyoExteriorController {
    
    private final PersonalApoyoExteriorService service;
    private final PersonalApoyoExteriorMapper mapper;

    @GetMapping
    public ResponseEntity<Page<PersonalApoyoExteriorDTO>> getAllAprendicesExt(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "12") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<PersonalApoyoExterior> pagePojo =  service.handleFindAllPaginate(pageable);
        Page<PersonalApoyoExteriorDTO> pageDTO = pagePojo.map(mapper::pojoToDto);
        return ResponseEntity.ok(pageDTO);
    }

    @GetMapping("/filtered")
    public ResponseEntity<Page<PersonalApoyoExteriorDTO>> getAllAprendicesExt(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "12") int size, @RequestBody PersonalApoyoExteriorDTO personalApoyoExteriorDTO){
        PersonalApoyoExterior personalApoyoExterior = mapper.dtoToPojo(personalApoyoExteriorDTO);
        Pageable pageable = PageRequest.of(page, size);
        Example<PersonalApoyoExterior> example = Example.of(personalApoyoExterior);
        Page<PersonalApoyoExterior> pagePojo =  service.handleFindAllPaginateByExample(example, pageable);
        Page<PersonalApoyoExteriorDTO> pageDTO = pagePojo.map(mapper::pojoToDto);
        return ResponseEntity.ok(pageDTO);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveAprendizExt(@RequestBody PersonalApoyoExteriorDTO personalApoyoExteriorDTO) {
        PersonalApoyoExterior personalApoyoExterior = mapper.dtoToPojo(personalApoyoExteriorDTO);
        service.handleCreateNewRegister(personalApoyoExterior);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/by-list")
    public ResponseEntity<HttpStatus> handleCreateNewListOfRegister(@RequestBody List<PersonalApoyoExteriorDTO> personalApoyoExteriorDTO)
            throws IllegalStateException {
        List<PersonalApoyoExterior> personalApoyoExterior = personalApoyoExteriorDTO.stream().map(mapper::dtoToPojo).toList();
        service.handleCreateNewListOfRegisters(personalApoyoExterior);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateAprendizExt(@RequestBody PersonalApoyoExteriorDTO personalApoyoExteriorDTO) {
        PersonalApoyoExterior personalApoyoExterior = mapper.dtoToPojo(personalApoyoExteriorDTO);
        if(!service.handleAlreadyExist(personalApoyoExterior)){
            //error
        }
        service.handleUpdate(personalApoyoExterior);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAprendizExt(@RequestParam UUID id) {
        /*
         * if(!service.handleAlreadyExist(id)) {
         * }
         */
        service.handleDeleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
