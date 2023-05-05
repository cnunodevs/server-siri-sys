package com.senatic.siri.controller;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

import com.senatic.siri.model.dto.InstructoresExtDTO;
import com.senatic.siri.model.entity.InstructoresExt;
import com.senatic.siri.model.mapper.InstructoresExtMapper;
import com.senatic.siri.service.InstructoresExtService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/instructores-ext")
public class InstructoresExtController {


    private final InstructoresExtService service;
    private final InstructoresExtMapper mapper;

    @GetMapping
    public ResponseEntity<Page<InstructoresExtDTO>> getAllAprendicesExt(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "12") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<InstructoresExt> pagePojo =  service.handleFindAllPaginate(pageable);
        Page<InstructoresExtDTO> pageDTO = pagePojo.map(mapper::pojoToDto);
        return ResponseEntity.ok(pageDTO);
    }

    @GetMapping("/filtered")
    public ResponseEntity<Page<InstructoresExtDTO>> getAllAprendicesExt(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "12") int size, @RequestBody InstructoresExtDTO instructoresExtDTO){
        InstructoresExt instructoresExt = mapper.dtoToPojo(instructoresExtDTO);
        Pageable pageable = PageRequest.of(page, size);
        Example<InstructoresExt> example = Example.of(instructoresExt);
        Page<InstructoresExt> pagePojo =  service.handleFindAllPaginateByExample(example, pageable);
        Page<InstructoresExtDTO> pageDTO = pagePojo.map(mapper::pojoToDto);
        return ResponseEntity.ok(pageDTO);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveAprendizExt(@RequestBody InstructoresExtDTO instructoresExtDTO) {
        InstructoresExt instructoresExt = mapper.dtoToPojo(instructoresExtDTO);
        service.handleCreateNewRegister(instructoresExt);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/by-list")
    public ResponseEntity<HttpStatus> handleCreateNewListOfRegister(@RequestBody List<InstructoresExtDTO> instructoresExtDTO)
            throws IllegalStateException {
        List<InstructoresExt> instructoresExt = instructoresExtDTO.stream().map(mapper::dtoToPojo).toList();
        service.handleCreateNewListOfRegisters(instructoresExt);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateAprendizExt(@RequestBody InstructoresExtDTO instructoresExtDTO) {
        InstructoresExt instructoresExt = mapper.dtoToPojo(instructoresExtDTO);
        if(!service.handleAlreadyExist(instructoresExt)){
            //error
        }
        service.handleUpdate(instructoresExt);
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
