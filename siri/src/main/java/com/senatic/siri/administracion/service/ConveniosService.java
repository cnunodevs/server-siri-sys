package com.senatic.siri.administracion.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.administracion.model.Convenio;
import com.senatic.siri.administracion.repository.ConveniosRepository;
import com.senatic.siri.common.GenericUseCases;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ConveniosService implements GenericUseCases<Convenio, Integer> {

    private final ConveniosRepository repository;

    @Override
    public List<Convenio> handleListAll() {
        return repository.findAll();
    }

    @Override
    public void handleUpdate(Convenio t) {
        repository.save(t);
    }

    @Override
    public void handleDelete(Convenio t) {
        repository.delete(t);
    }

    @Override
    public void handleDeleteById(Integer u) {
        repository.deleteById(u);
    }

    @Override
    public Page<Convenio> handleFindAllPaginateByExample(Example<Convenio> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<Convenio> handleFindAllByExample(Example<Convenio> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<Convenio> handleFindAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Boolean handleAlreadyExist(Convenio t) {
        return repository.exists(Example.of(t));
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        return repository.existsById(u);
    }

    @Override
    public void handleCreateNewRegister(Convenio t) {
        repository.save(t);
    }

    @Override
    public void handleCreateNewListOfRegisters(List<Convenio> list) {
        repository.saveAll(list);
    }
}
