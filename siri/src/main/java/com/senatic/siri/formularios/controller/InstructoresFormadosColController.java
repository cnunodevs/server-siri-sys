package com.senatic.siri.formularios.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import org.springframework.web.multipart.MultipartFile;

import com.senatic.siri.formularios.model.InstructoresFormadosCol;
import com.senatic.siri.formularios.service.InstructoresFormadosColService;

import jakarta.persistence.EntityNotFoundException;

@Validated
@CrossOrigin
@RestController
@RequestMapping("api/v1/instructores-formados-col")
public class InstructoresFormadosColController {

    private final InstructoresFormadosColService service;

    public InstructoresFormadosColController(InstructoresFormadosColService service) {
        this.service = service;
    }

    @GetMapping("list/all")
    public ResponseEntity<List<InstructoresFormadosCol>> handleListAllRegister() {
        List<InstructoresFormadosCol> listPOJO = service.handleListAll();
        return ResponseEntity.status(HttpStatus.OK).body(listPOJO);
    }

    @GetMapping("list/paginate")
    public ResponseEntity<Page<InstructoresFormadosCol>> handleFindAllPaginate(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "9") Integer size) {
        Pageable paging = PageRequest.of(page, size);
        Page<InstructoresFormadosCol> listPOJO = service.handleFindAllPaginate(paging);
        return ResponseEntity.status(HttpStatus.OK).body(listPOJO);
    }

    @PostMapping("create")
    public ResponseEntity<HttpStatus> handleCreateNewRegister(@RequestBody InstructoresFormadosCol pojo) {
        if (service.handleAlreadyExist(pojo)) {
            throw new IllegalStateException("Exception message");
        }
        service.handleCreateNewRegister(pojo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("upload-file")
    public ResponseEntity<HttpStatus> handleUploadMasiveData(MultipartFile file) throws IOException {
        service.handleUploadExcelFile(file);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("update/by-id/{id}")
    public ResponseEntity<HttpStatus> handleUpdateRegister(@RequestBody InstructoresFormadosCol pojo, @PathVariable("id") Integer id) {
        if (service.handleAlreadyExistById(id)) {
            throw new EntityNotFoundException("Exception message");
        }
        service.handleUpdate(pojo);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("delete/by-id/{id}")
    public ResponseEntity<HttpStatus> handleDeleteRegisterById(@PathVariable("id") Integer id) {
        if (service.handleAlreadyExistById(id)) {
            throw new EntityNotFoundException("Exception message");
        }
        service.handleDeleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
