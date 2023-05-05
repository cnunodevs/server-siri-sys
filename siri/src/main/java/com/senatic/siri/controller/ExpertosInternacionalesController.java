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

import com.senatic.siri.model.dto.ExpertosInternacionalDTO;
import com.senatic.siri.model.entity.ExpertosInternacionales;
import com.senatic.siri.model.mapper.ExpertosInternacionalesMapper;
import com.senatic.siri.service.ExpertosInternacionalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/expertos-internacionales")
public class ExpertosInternacionalesController {

    private final ExpertosInternacionalService service;
    private final ExpertosInternacionalesMapper mapper;

    @GetMapping
    public ResponseEntity<Page<ExpertosInternacionalDTO>> getAllAprendicesExt(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "12") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<ExpertosInternacionales> pagePojo =  service.handleFindAllPaginate(pageable);
        Page<ExpertosInternacionalDTO> pageDTO = pagePojo.map(mapper::pojoToDto);
        return ResponseEntity.ok(pageDTO);
    }

    @GetMapping("/filtered")
    public ResponseEntity<Page<ExpertosInternacionalDTO>> getAllAprendicesExt(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "12") int size, @RequestBody ExpertosInternacionalDTO expertosInternacionalDTO){
        ExpertosInternacionales expertosInternacional = mapper.dtoToPojo(expertosInternacionalDTO);
        Pageable pageable = PageRequest.of(page, size);
        Example<ExpertosInternacionales> example = Example.of(expertosInternacional);
        Page<ExpertosInternacionales> pagePojo =  service.handleFindAllPaginateByExample(example, pageable);
        Page<ExpertosInternacionalDTO> pageDTO = pagePojo.map(mapper::pojoToDto);
        return ResponseEntity.ok(pageDTO);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveAprendizExt(@RequestBody ExpertosInternacionalDTO aprendicezExtDTO) {
        ExpertosInternacionales expertosInternacional = mapper.dtoToPojo(aprendicezExtDTO);
        service.handleCreateNewRegister(expertosInternacional);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/by-list")
    public ResponseEntity<HttpStatus> handleCreateNewListOfRegister(@RequestBody List<ExpertosInternacionalDTO> expertosInternacionalesDTO)
            throws IllegalStateException {
        List<ExpertosInternacionales> expertosInternacionales = expertosInternacionalesDTO.stream().map(mapper::dtoToPojo).toList();
        service.handleCreateNewListOfRegisters(expertosInternacionales);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PutMapping
    public ResponseEntity<HttpStatus> updateAprendizExt(@RequestBody ExpertosInternacionalDTO expertosInternacionalDTO) {
        ExpertosInternacionales expertosInternacional = mapper.dtoToPojo(expertosInternacionalDTO);
        if(!service.handleAlreadyExist(expertosInternacional)){
            //error
        }
        service.handleUpdate(expertosInternacional);
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
