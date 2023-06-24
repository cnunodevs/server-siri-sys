package com.senatic.siri.formularios.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.common.GenericUseCases;
import com.senatic.siri.formularios.model.VoluntariosInstructoresFormadosCol;
import com.senatic.siri.formularios.repository.VoluntariosInstructoresFormadosColRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class VoluntariosInstructoresFormadosColService implements GenericUseCases<VoluntariosInstructoresFormadosCol, Integer> {

    private final VoluntariosInstructoresFormadosColRepository repository;

    @Override
    public List<VoluntariosInstructoresFormadosCol> handleListAll() {
        return repository.findAll();
    }

    @Override
    public void handleUpdate(VoluntariosInstructoresFormadosCol t) {
        repository.save(t);
    }

    @Override
    public void handleDelete(VoluntariosInstructoresFormadosCol t) {
        repository.delete(t);
    }

    @Override
    public void handleDeleteById(Integer u) {
        repository.deleteById(u);
    }

    @Override
    public Page<VoluntariosInstructoresFormadosCol> handleFindAllPaginateByExample(
            Example<VoluntariosInstructoresFormadosCol> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<VoluntariosInstructoresFormadosCol> handleFindAllByExample(
            Example<VoluntariosInstructoresFormadosCol> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<VoluntariosInstructoresFormadosCol> handleFindAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Boolean handleAlreadyExist(VoluntariosInstructoresFormadosCol t) {
        return repository.exists(Example.of(t));
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        return repository.existsById(u);
    }

    @Override
    public void handleCreateNewRegister(VoluntariosInstructoresFormadosCol t) {
        repository.save(t);
    }

    @Override
    public void handleCreateNewListOfRegisters(List<VoluntariosInstructoresFormadosCol> list) {
        repository.saveAll(list);
    }
}
