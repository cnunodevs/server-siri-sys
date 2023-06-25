package com.senatic.siri.administracion.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.administracion.model.Pais;
import com.senatic.siri.administracion.repository.PaisesRepository;
import com.senatic.siri.common.GenericUseCases;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PaisesService implements GenericUseCases<Pais, Integer> {

    private final PaisesRepository repository;

    @Override
    public List<Pais> handleListAll() {
        return repository.findAll();
    }

    @Override
    public void handleUpdate(Pais t) {
        repository.save(t);
    }

    @Override
    public void handleDelete(Pais t) {
        repository.delete(t);
    }

    @Override
    public void handleDeleteById(Integer u) {
        repository.deleteById(u);
    }

    @Override
    public Page<Pais> handleFindAllPaginateByExample(Example<Pais> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<Pais> handleFindAllByExample(Example<Pais> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<Pais> handleFindAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Boolean handleAlreadyExist(Pais t) {
        return repository.exists(Example.of(t));
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        return repository.existsById(u);
    }

    @Override
    public void handleCreateNewRegister(Pais t) {
        repository.save(t);
    }

    @Override
    public void handleCreateNewListOfRegisters(List<Pais> list) {
        repository.saveAll(list);
    }
}
