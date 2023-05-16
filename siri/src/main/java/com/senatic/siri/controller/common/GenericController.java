package com.senatic.siri.controller.common;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.senatic.siri.model.mapper.common.GenericMapper;
import com.senatic.siri.service.common.GenericUseCases;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GenericController<D, P> {
    
    protected final GenericUseCases<P, UUID> service;
    protected final GenericMapper<P, D>  mapper;

    @GetMapping("/paginate")
    public ResponseEntity<Page<D>> handleFindAllPaginate(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "9") Integer size) {
        Pageable paging = PageRequest.of(page, size);
        Page<P> listPOJO = service.handleFindAllPaginate(paging);
        Page<D> listDTO = new PageImpl<D>(listPOJO.map(mapper::pojoToDto).toList());
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<D>> handleFindAllPaginateByExample(
            @RequestBody D exampleDTO,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "9") Integer size) {
        Example<P> example = Example.of(mapper.dtoToPojo(exampleDTO));
        Pageable paging = PageRequest.of(page, size);
        Page<P> listPOJO = service.handleFindAllPaginateByExample(example, paging);
        Page<D> listDTO = new PageImpl<D>(listPOJO.map(mapper::pojoToDto).toList());
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> handleCreateNewRegister(@RequestBody D dto)
            throws IllegalStateException {
        P pojo = mapper.dtoToPojo(dto);
        if (service.handleAlreadyExist(pojo)) {
            throw new IllegalStateException("Exception message");
        }
        service.handleCreateNewRegister(pojo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/by-list")
    public ResponseEntity<HttpStatus> handleCreateNewListOfRegister(@RequestBody List<D> listDTO)
            throws IllegalStateException {
        List<P> listPOJO = listDTO.stream().map(mapper::dtoToPojo).toList();
        service.handleCreateNewListOfRegisters(listPOJO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> handleDeleteRegisterById(@RequestParam("id") UUID id)
            throws EntityNotFoundException {
        if (service.handleAlreadyExistById(id)) {
            throw new EntityNotFoundException("Exception message");
        }
        service.handleDeleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping
    public ResponseEntity<HttpStatus> handleUpdateRegister(@RequestBody D dto, @RequestParam UUID id)
            throws EntityNotFoundException {
        if (service.handleAlreadyExistById(id)) {
            throw new EntityNotFoundException("Exception message");
        }
        service.handleUpdate(mapper.dtoToPojo(dto));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

}
