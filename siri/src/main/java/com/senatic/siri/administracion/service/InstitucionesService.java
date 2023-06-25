package com.senatic.siri.administracion.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.administracion.model.Institucion;
import com.senatic.siri.administracion.repository.InstitucionesRepository;
import com.senatic.siri.common.GenericUseCases;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class InstitucionesService implements GenericUseCases<Institucion, Integer> {

    private final InstitucionesRepository repository;

    @Override
    public List<Institucion> handleListAll() {
        return repository.findAll();
    }

    @Override
    public void handleUpdate(Institucion t) {
        repository.save(t);
    }

    @Override
    public void handleDelete(Institucion t) {
        repository.delete(t);
    }

    @Override
    public void handleDeleteById(Integer u) {
        repository.deleteById(u);
    }

    @Override
    public Page<Institucion> handleFindAllPaginateByExample(Example<Institucion> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<Institucion> handleFindAllByExample(Example<Institucion> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<Institucion> handleFindAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Boolean handleAlreadyExist(Institucion t) {
        return repository.exists(Example.of(t));
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        return repository.existsById(u);
    }

    @Override
    public void handleCreateNewRegister(Institucion t) {
        repository.save(t);
    }

    @Override
    public void handleCreateNewListOfRegisters(List<Institucion> list) {
        repository.saveAll(list);
    }
}
