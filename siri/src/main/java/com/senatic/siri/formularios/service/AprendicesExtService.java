package com.senatic.siri.formularios.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.common.GenericUseCases;
import com.senatic.siri.formularios.model.AprendicesExt;
import com.senatic.siri.formularios.repository.AprendicesExtRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AprendicesExtService implements GenericUseCases<AprendicesExt, Integer> {

    private final AprendicesExtRepository repository;

    @Override
    public List<AprendicesExt> handleListAll() {
        return repository.findAll();
    }

    @Override
    public void handleUpdate(AprendicesExt t) {
        repository.save(t);
    }

    @Override
    public void handleDelete(AprendicesExt t) {
        repository.delete(t);
    }

    @Override
    public void handleDeleteById(Integer u) {
        repository.deleteById(u);
    }

    @Override
    public Page<AprendicesExt> handleFindAllPaginateByExample(Example<AprendicesExt> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<AprendicesExt> handleFindAllByExample(Example<AprendicesExt> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<AprendicesExt> handleFindAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Boolean handleAlreadyExist(AprendicesExt t) {
        return repository.exists(Example.of(t));
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        return repository.exists(Example.of(AprendicesExt.builder().id(u).build()));
    }

    @Override
    public void handleCreateNewRegister(AprendicesExt t) {
        repository.save(t);
    }

    @Override
    public void handleCreateNewListOfRegisters(List<AprendicesExt> list) {
        repository.saveAll(list);
    }

}
