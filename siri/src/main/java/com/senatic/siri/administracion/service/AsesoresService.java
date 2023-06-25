package com.senatic.siri.administracion.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.administracion.model.Asesor;
import com.senatic.siri.administracion.repository.AsesoresRepository;
import com.senatic.siri.common.GenericUseCases;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AsesoresService implements GenericUseCases<Asesor, Integer> {

    private final AsesoresRepository repository;

    @Override
    public List<Asesor> handleListAll() {
        return repository.findAll();
    }

    @Override
    public void handleUpdate(Asesor t) {
        repository.save(t);
    }

    @Override
    public void handleDelete(Asesor t) {
        repository.delete(t);
    }

    @Override
    public void handleDeleteById(Integer u) {
        repository.deleteById(u);
    }

    @Override
    public Page<Asesor> handleFindAllPaginateByExample(Example<Asesor> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<Asesor> handleFindAllByExample(Example<Asesor> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<Asesor> handleFindAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Boolean handleAlreadyExist(Asesor t) {
        return repository.exists(Example.of(t));
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        return repository.existsById(u);
    }

    @Override
    public void handleCreateNewRegister(Asesor t) {
        repository.save(t);
    }

    @Override
    public void handleCreateNewListOfRegisters(List<Asesor> list) {
        repository.saveAll(list);
    }
}
