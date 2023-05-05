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

import com.senatic.siri.model.dto.VoluntariosInternacionalesDTO;
import com.senatic.siri.model.entity.VoluntariosInternacionales;
import com.senatic.siri.model.mapper.VoluntariosInternacionalesMapper;
import com.senatic.siri.service.VoluntariosInternacionalesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/voluntarios-internacionales")
public class VoluntariosInternacionalesController {

    private final VoluntariosInternacionalesService service;
    private final VoluntariosInternacionalesMapper mapper;

    @GetMapping
    public ResponseEntity<Page<VoluntariosInternacionalesDTO>> getAllAprendicesExt(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "12") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<VoluntariosInternacionales> pagePojo =  service.handleFindAllPaginate(pageable);
        Page<VoluntariosInternacionalesDTO> pageDTO = pagePojo.map(mapper::pojoToDto);
        return ResponseEntity.ok(pageDTO);
    }

    @GetMapping("/filtered")
    public ResponseEntity<Page<VoluntariosInternacionalesDTO>> getAllAprendicesExt(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "12") int size, @RequestBody VoluntariosInternacionalesDTO voluntariosInternacionalesDTO){
        VoluntariosInternacionales voluntariosInternacionales = mapper.dtoToPojo(voluntariosInternacionalesDTO);
        Pageable pageable = PageRequest.of(page, size);
        Example<VoluntariosInternacionales> example = Example.of(voluntariosInternacionales);
        Page<VoluntariosInternacionales> pagePojo =  service.handleFindAllPaginateByExample(example, pageable);
        Page<VoluntariosInternacionalesDTO> pageDTO = pagePojo.map(mapper::pojoToDto);
        return ResponseEntity.ok(pageDTO);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveAprendizExt(@RequestBody VoluntariosInternacionalesDTO voluntariosInternacionalesDTO) {
        VoluntariosInternacionales voluntariosInternacionales = mapper.dtoToPojo(voluntariosInternacionalesDTO);
        service.handleCreateNewRegister(voluntariosInternacionales);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/by-list")
    public ResponseEntity<HttpStatus> handleCreateNewListOfRegister(@RequestBody List<VoluntariosInternacionalesDTO> voluntariosInternacionalesDTO)
            throws IllegalStateException {
        List<VoluntariosInternacionales> voluntariosInternacionales = voluntariosInternacionalesDTO.stream().map(mapper::dtoToPojo).toList();
        service.handleCreateNewListOfRegisters(voluntariosInternacionales);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateAprendizExt(@RequestBody VoluntariosInternacionalesDTO voluntariosInternacionalesDTO) {
        VoluntariosInternacionales voluntariosInternacionales = mapper.dtoToPojo(voluntariosInternacionalesDTO);
        if(!service.handleAlreadyExist(voluntariosInternacionales)){
            //error
        }
        service.handleUpdate(voluntariosInternacionales);
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
