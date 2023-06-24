package com.senatic.siri.formularios.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.common.GenericUseCases;
import com.senatic.siri.formularios.model.AprendicesFormadosCol;
import com.senatic.siri.formularios.repository.AprendicesFormadosColRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AprendicesFormadosColService implements GenericUseCases<AprendicesFormadosCol, Integer> {

    private final AprendicesFormadosColRepository repository;

    @Override
    public List<AprendicesFormadosCol> handleListAll() {
        return repository.findAll();
    }

    @Override
    public void handleUpdate(AprendicesFormadosCol t) {
        repository.save(t);
    }

    @Override
    public void handleDelete(AprendicesFormadosCol t) {
        repository.delete(t);
    }

    @Override
    public void handleDeleteById(Integer u) {
        repository.deleteById(u);
    }

    @Override
    public Page<AprendicesFormadosCol> handleFindAllPaginateByExample(Example<AprendicesFormadosCol> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<AprendicesFormadosCol> handleFindAllByExample(Example<AprendicesFormadosCol> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<AprendicesFormadosCol> handleFindAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Boolean handleAlreadyExist(AprendicesFormadosCol t) {
        return repository.exists(Example.of(t));
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        return repository.existsById(u);
    }

    @Override
    public void handleCreateNewRegister(AprendicesFormadosCol t) {
        repository.save(t);
    }

    @Override
    public void handleCreateNewListOfRegisters(List<AprendicesFormadosCol> list) {
        repository.saveAll(list);
    }
}
