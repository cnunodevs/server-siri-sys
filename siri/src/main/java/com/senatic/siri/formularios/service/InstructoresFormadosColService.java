package com.senatic.siri.formularios.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.common.GenericUseCases;
import com.senatic.siri.formularios.model.InstructoresFormadosCol;
import com.senatic.siri.formularios.repository.InstructoresFormadosColRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class InstructoresFormadosColService implements GenericUseCases<InstructoresFormadosCol, Integer> {

    private final InstructoresFormadosColRepository repository;

    @Override
    public List<InstructoresFormadosCol> handleListAll() {
        return repository.findAll();
    }

    @Override
    public void handleUpdate(InstructoresFormadosCol t) {
        repository.save(t);
    }

    @Override
    public void handleDelete(InstructoresFormadosCol t) {
        repository.delete(t);
    }

    @Override
    public void handleDeleteById(Integer u) {
        repository.deleteById(u);
    }

    @Override
    public Page<InstructoresFormadosCol> handleFindAllPaginateByExample(Example<InstructoresFormadosCol> example,
            Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<InstructoresFormadosCol> handleFindAllByExample(Example<InstructoresFormadosCol> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<InstructoresFormadosCol> handleFindAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Boolean handleAlreadyExist(InstructoresFormadosCol t) {
        return repository.exists(Example.of(t));
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        return repository.existsById(u);
    }

    @Override
    public void handleCreateNewRegister(InstructoresFormadosCol t) {
        repository.save(t);
    }

    @Override
    public void handleCreateNewListOfRegisters(List<InstructoresFormadosCol> list) {
        repository.saveAll(list);
    }
}