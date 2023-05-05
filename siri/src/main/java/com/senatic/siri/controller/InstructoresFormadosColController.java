package com.senatic.siri.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senatic.siri.model.dto.InstructoresFormadosColDTO;
import com.senatic.siri.model.entity.InstructoresFormadosCol;
import com.senatic.siri.model.mapper.InsFormColMapper;
import com.senatic.siri.service.InstructoresFormadosColService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/instructores-formados-col")
public class InstructoresFormadosColController {

    private final InstructoresFormadosColService instructoresFormadosColService;
    private final InsFormColMapper insFormColMapper;

    @GetMapping("/paginate")
    public ResponseEntity<Page<InstructoresFormadosColDTO>> handleFindAllPaginate(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "9") Integer size) {
        Pageable paging = PageRequest.of(page, size);
        Page<InstructoresFormadosCol> instructores = instructoresFormadosColService.handleFindAllPaginate(paging);
        Page<InstructoresFormadosColDTO> instructoresDTO = new PageImpl<InstructoresFormadosColDTO>(instructores.map(insFormColMapper::pojoToDto).toList());
        return ResponseEntity.status(HttpStatus.OK).body(instructoresDTO);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<InstructoresFormadosColDTO>> handleFindAllPaginateByExample(
            @RequestBody InstructoresFormadosColDTO exampleDTO,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "9") Integer size) {
        Example<InstructoresFormadosCol> example = Example.of(insFormColMapper.dtoToPojo(exampleDTO));
        Pageable paging = PageRequest.of(page, size);
        Page<InstructoresFormadosCol> instructores = instructoresFormadosColService.handleFindAllPaginateByExample(example, paging);
        Page<InstructoresFormadosColDTO> instructoresDTO = new PageImpl<InstructoresFormadosColDTO>(instructores.map(insFormColMapper::pojoToDto).toList());
        return ResponseEntity.status(HttpStatus.OK).body(instructoresDTO);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> handleCreateNewRegister(@RequestBody InstructoresFormadosColDTO instructorDTO)
            throws IllegalStateException {
        InstructoresFormadosCol instructor = insFormColMapper.dtoToPojo(instructorDTO);
        if (instructoresFormadosColService.handleAlreadyExist(instructor)) {
            throw new IllegalStateException("Exception message");
        }
        instructoresFormadosColService.handleCreateNewRegister(instructor);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/by-list")
    public ResponseEntity<HttpStatus> handleCreateNewListOfRegister(@RequestBody List<InstructoresFormadosColDTO> instructoresDTO)
            throws IllegalStateException {
        List<InstructoresFormadosCol> instructores = instructoresDTO.stream().map(insFormColMapper::dtoToPojo).toList();
        instructoresFormadosColService.handleCreateNewListOfRegisters(instructores);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> handleDeleteRegisterById(@PathVariable UUID id)
            throws EntityNotFoundException {
        if (instructoresFormadosColService.handleAlreadyExistById(id)) {
            throw new EntityNotFoundException("Exception message");
        }
        instructoresFormadosColService.handleDeleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping
    public ResponseEntity<HttpStatus> handleUpdateRegister(@RequestBody InstructoresFormadosColDTO instructorDTO)
            throws EntityNotFoundException {
        if (instructoresFormadosColService.handleAlreadyExistById(instructorDTO.getId())) {
            throw new EntityNotFoundException("Exception message");
        }
        instructoresFormadosColService.handleUpdate(insFormColMapper.dtoToPojo(instructorDTO));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
    
}
