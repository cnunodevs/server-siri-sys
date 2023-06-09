package com.senatic.siri.administracion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.senatic.siri.administracion.model.Usuario;
import com.senatic.siri.administracion.repository.UsuariosRepository;
import com.senatic.siri.common.GenericUseCases;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuariosService implements GenericUseCases<Usuario, Integer> {

    private final UsuariosRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> handleListAll() {
        return repository.findAll();
    }

    @Override
    public void handleUpdate(Usuario t) {
        repository.save(t);
    }

    @Override
    public void handleDelete(Usuario t) {
        repository.delete(t);
    }

    @Override
    public void handleDeleteById(Integer u) {
        repository.deleteById(u);
    }

    @Override
    public Page<Usuario> handleFindAllPaginateByExample(Example<Usuario> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<Usuario> handleFindAllByExample(Example<Usuario> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<Usuario> handleFindAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Boolean handleAlreadyExist(Usuario t) {
        return repository.exists(Example.of(t));
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        return repository.existsById(u);
    }

    @Override
    public void handleCreateNewRegister(Usuario t) {
        t.setPassword(passwordEncoder.encode(t.getPassword()));
        repository.save(t);
    }

    @Override
    public void handleCreateNewListOfRegisters(List<Usuario> list) {
        repository.saveAll(list);
    }

    public Optional<Usuario> findByUsername(String username) {
        return repository.findFirstByUsername(username);
    }

    public Boolean usernameAlreadyExist(String username) {
        return repository.exists(Example.of(Usuario.builder().username(username).build()));
    }
}