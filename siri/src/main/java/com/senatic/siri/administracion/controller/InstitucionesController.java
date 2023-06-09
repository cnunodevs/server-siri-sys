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

import com.senatic.siri.administracion.model.Institucion;
import com.senatic.siri.administracion.service.InstitucionesService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("api/v1/instituciones")
public class InstitucionesController {

    private final InstitucionesService service;

    public InstitucionesController(InstitucionesService service) {
        this.service = service;
    }

    @GetMapping("list/all")
    public ResponseEntity<List<Institucion>> handleListAllRegisters() {
        List<Institucion> listPOJO = service.handleListAll();
        return ResponseEntity.status(HttpStatus.OK).body(listPOJO);
    }

    @GetMapping("list/paginate")
    public ResponseEntity<Page<Institucion>> handleFindAllPaginate(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "9") Integer size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Institucion> listPOJO = service.handleFindAllPaginate(paging);
        return ResponseEntity.status(HttpStatus.OK).body(listPOJO);
    }

    @PostMapping("create")
    public ResponseEntity<HttpStatus> handleCreateNewRegister(@RequestBody Institucion institucion) {
        if (service.handleAlreadyExistById(institucion.getId())) {
            throw new IllegalStateException("Institucion already exists");
        }
        service.handleCreateNewRegister(institucion);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("update/by-id/{id}")
    public ResponseEntity<HttpStatus> handleUpdateRegister(
            @RequestBody Institucion institucion,
            @PathVariable("id") Integer id) {
        if (!service.handleAlreadyExistById(id)) {
            throw new EntityNotFoundException("Institucion not found");
        }
        institucion.setId(id);
        service.handleUpdate(institucion);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("delete/by-id/{id}")
    public ResponseEntity<HttpStatus> handleDeleteRegisterById(@PathVariable("id") Integer id) {
        if (!service.handleAlreadyExistById(id)) {
            throw new EntityNotFoundException("Institucion not found");
        }
        service.handleDeleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
