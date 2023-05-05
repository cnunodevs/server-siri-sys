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
import org.springframework.validation.annotation.Validated;
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

import com.senatic.siri.model.dto.AprendicesFormadosColDTO;
import com.senatic.siri.model.entity.AprendicesFormadosCol;
import com.senatic.siri.model.mapper.AprFormColMapper;
import com.senatic.siri.service.AprendicesFormadosColService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;


@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/aprendices-formados-col")
public class AprendicesFormadosColController {

    private final AprendicesFormadosColService aprendicesFormadosColService;
    private final AprFormColMapper aprFormColMapper;

    @GetMapping
    public ResponseEntity<Page<AprendicesFormadosColDTO>> handleFindAllPaginate(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "9") Integer size) {
        Pageable paging = PageRequest.of(page, size);
        Page<AprendicesFormadosCol> aprendices = aprendicesFormadosColService.handleFindAllPaginate(paging);
        Page<AprendicesFormadosColDTO> aprendicesDTO = new PageImpl<AprendicesFormadosColDTO>(aprendices.map(aprFormColMapper::pojoToDto).toList());
        return ResponseEntity.status(HttpStatus.OK).body(aprendicesDTO);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<AprendicesFormadosColDTO>> handleFindAllPaginateByExample(
            @RequestBody AprendicesFormadosColDTO exampleDTO,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "9") Integer size) {
        Example<AprendicesFormadosCol> example = Example.of(aprFormColMapper.dtoToPojo(exampleDTO));
        Pageable paging = PageRequest.of(page, size);
        Page<AprendicesFormadosCol> aprendices = aprendicesFormadosColService.handleFindAllPaginateByExample(example, paging);
        Page<AprendicesFormadosColDTO> aprendicesDTO = new PageImpl<AprendicesFormadosColDTO>(aprendices.map(aprFormColMapper::pojoToDto).toList());
        return ResponseEntity.status(HttpStatus.OK).body(aprendicesDTO);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> handleCreateNewRegister(@RequestBody AprendicesFormadosColDTO aprendizDTO)
            throws IllegalStateException {
        AprendicesFormadosCol aprendiz = aprFormColMapper.dtoToPojo(aprendizDTO);
        if (aprendicesFormadosColService.handleAlreadyExist(aprendiz)) {
            throw new IllegalStateException("Exception message");
        }
        aprendicesFormadosColService.handleCreateNewRegister(aprendiz);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping
    public ResponseEntity<HttpStatus> handleCreateNewRegister(@RequestBody List<AprendicesFormadosColDTO> aprendicesDTO)
            throws IllegalStateException {
        List<AprendicesFormadosCol> aprendices = aprendicesDTO.stream().map(aprFormColMapper::dtoToPojo).toList();
        aprendicesFormadosColService.handleCreateNewListOfRegisters(aprendices);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> handleDeleteRegisterById(@PathVariable UUID id)
            throws EntityNotFoundException {
        if (aprendicesFormadosColService.handleAlreadyExistById(id)) {
            throw new EntityNotFoundException("Exception message");
        }
        aprendicesFormadosColService.handleDeleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping
    public ResponseEntity<HttpStatus> handleUpdateRegister(@RequestBody AprendicesFormadosColDTO aprendizDTO)
            throws EntityNotFoundException {
        if (aprendicesFormadosColService.handleAlreadyExistById(aprendizDTO.getId())) {
            throw new EntityNotFoundException("Exception message");
        }
        aprendicesFormadosColService.handleUpdate(aprFormColMapper.dtoToPojo(aprendizDTO));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
    
}
