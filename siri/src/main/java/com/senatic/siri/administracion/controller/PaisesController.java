package com.senatic.siri.administracion.controller;

import java.util.List;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Page;
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

import com.senatic.siri.administracion.model.Pais;
import com.senatic.siri.administracion.service.PaisesService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("api/v1/paises")
public class PaisesController {

    private final PaisesService service;

    public PaisesController(PaisesService service) {
        this.service = service;
    }

    @GetMapping("list/all")
    public ResponseEntity<List<Pais>> handleListAllRegisters() {
        List<Pais> listPOJO = service.handleListAll();
        return ResponseEntity.status(HttpStatus.OK).body(listPOJO);
    }

    @GetMapping("list/paginate")
    public ResponseEntity<Page<Pais>> handleFindAllPaginate(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "9") Integer size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Pais> listPOJO = service.handleFindAllPaginate(paging);
        return ResponseEntity.status(HttpStatus.OK).body(listPOJO);
    }

    @PostMapping("create")
    public ResponseEntity<HttpStatus> handleCreateNewRegister(@RequestBody Pais pais) {
        if (service.handleAlreadyExistById(pais.getId())) {
            throw new IllegalStateException("Pais already exists");
        }
        service.handleCreateNewRegister(pais);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("update/by-id/{id}")
    public ResponseEntity<HttpStatus> handleUpdateRegister(
            @RequestBody Pais pais,
            @PathVariable("id") Integer id) {
        if (!service.handleAlreadyExistById(id)) {
            throw new EntityNotFoundException("Pais not found");
        }
        pais.setId(id);
        service.handleUpdate(pais);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("delete/by-id/{id}")
    public ResponseEntity<HttpStatus> handleDeleteRegisterById(@PathVariable("id") Integer id) {
        if (!service.handleAlreadyExistById(id)) {
            throw new EntityNotFoundException("Pais not found");
        }
        service.handleDeleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
