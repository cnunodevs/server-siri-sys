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

import com.senatic.siri.administracion.model.Usuario;
import com.senatic.siri.administracion.service.UsuariosService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuariosController {

    private final UsuariosService service;

    public UsuariosController(UsuariosService service) {
        this.service = service;
    }

    @GetMapping("list/all")
    public ResponseEntity<List<Usuario>> handleListAllRegisters() {
        List<Usuario> listPOJO = service.getAllUsuarios();
        return ResponseEntity.status(HttpStatus.OK).body(listPOJO);
    }

    @GetMapping("list/paginate")
    public ResponseEntity<Page<Usuario>> handleFindAllPaginate(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "9") Integer size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Usuario> listPOJO = service.getAllUsuariosPaginated(paging);
        return ResponseEntity.status(HttpStatus.OK).body(listPOJO);
    }

    @PostMapping("create")
    public ResponseEntity<HttpStatus> handleCreateNewRegister(@RequestBody Usuario usuario) {
        if (service.usuarioExists(usuario.getId())) {
            throw new IllegalStateException("Usuario already exists");
        }
        service.createUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("update/by-id/{id}")
    public ResponseEntity<HttpStatus> handleUpdateRegister(
            @RequestBody Usuario usuario,
            @PathVariable("id") Integer id) {
        if (!service.usuarioExists(id)) {
            throw new EntityNotFoundException("Usuario not found");
        }
        usuario.setId(id);
        service.updateUsuario(usuario);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("delete/by-id/{id}")
    public ResponseEntity<HttpStatus> handleDeleteRegisterById(@PathVariable("id") Integer id) {
        if (!service.usuarioExists(id)) {
            throw new EntityNotFoundException("Usuario not found");
        }
        service.deleteUsuarioById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
