package com.senatic.siri.formularios.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.common.GenericUseCases;
import com.senatic.siri.formularios.model.InstructoresExt;
import com.senatic.siri.formularios.repository.InstructoresExtRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class InstructoresExtService implements GenericUseCases<InstructoresExt, Integer> {

    private final InstructoresExtRepository repository;

    @Override
    public List<InstructoresExt> handleListAll() {
        return repository.findAll();
    }

    @Override
    public void handleUpdate(InstructoresExt t) {
        repository.save(t);
    }

    @Override
    public void handleDelete(InstructoresExt t) {
        repository.delete(t);
    }

    @Override
    public void handleDeleteById(Integer u) {
        repository.deleteById(u);
    }

    @Override
    public Page<InstructoresExt> handleFindAllPaginateByExample(Example<InstructoresExt> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<InstructoresExt> handleFindAllByExample(Example<InstructoresExt> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<InstructoresExt> handleFindAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Boolean handleAlreadyExist(InstructoresExt t) {
        return repository.exists(Example.of(t));
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        return repository.existsById(u);
    }

    @Override
    public void handleCreateNewRegister(InstructoresExt t) {
        repository.save(t);
    }

    @Override
    public void handleCreateNewListOfRegisters(List<InstructoresExt> list) {
        repository.saveAll(list);
    }
}
