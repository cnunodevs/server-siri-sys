package com.senatic.siri.controller;

import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.model.dto.AprendicesExtDTO;
import com.senatic.siri.model.entity.AprendicesExt;
import com.senatic.siri.model.mapper.AprendicesExtMapper;
import com.senatic.siri.service.AprendicesExtService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/aprendices-ext")
public class AprendicesExtController {

    private final AprendicesExtService service;
    private final AprendicesExtMapper mapper;

    @GetMapping
    public ResponseEntity<Page<AprendicesExtDTO>> getAllAprendicesExt(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "12") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<AprendicesExt> pagePojo =  service.handleFindAllPaginate(pageable);
        Page<AprendicesExtDTO> pageDTO = pagePojo.map(mapper::pojoToDto);
        return ResponseEntity.ok(pageDTO);
    }

    @GetMapping("/filtered")
    public ResponseEntity<Page<AprendicesExtDTO>> getAllAprendicesExt(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "12") int size, @RequestBody AprendicesExtDTO aprendicesExtDTO){
        AprendicesExt aprendicesExt = mapper.dtoToPojo(aprendicesExtDTO);
        Pageable pageable = PageRequest.of(page, size);
        Example<AprendicesExt> example = Example.of(aprendicesExt);
        Page<AprendicesExt> pagePojo =  service.handleFindAllPaginateByExample(example, pageable);
        Page<AprendicesExtDTO> pageDTO = pagePojo.map(mapper::pojoToDto);
        return ResponseEntity.ok(pageDTO);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveAprendizExt(@RequestBody AprendicesExtDTO aprendicezExtDTO) {
        AprendicesExt aprendizExt = mapper.dtoToPojo(aprendicezExtDTO);
        service.handleCreateNewRegister(aprendizExt);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/by-list")
    public ResponseEntity<HttpStatus> handleCreateNewListOfRegister(@RequestBody List<AprendicesExtDTO> aprendicesDTO)
            throws IllegalStateException {
        List<AprendicesExt> aprendices = aprendicesDTO.stream().map(mapper::dtoToPojo).toList();
        service.handleCreateNewListOfRegisters(aprendices);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateAprendizExt(@RequestBody AprendicesExtDTO aprendicezExtDTO) {
        AprendicesExt aprendizExt = mapper.dtoToPojo(aprendicezExtDTO);
        if(!service.handleAlreadyExist(aprendizExt)){
            //error
        }
        service.handleUpdate(aprendizExt);
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
