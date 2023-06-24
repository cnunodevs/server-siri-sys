package com.senatic.siri.formularios.service;


import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.common.GenericUseCases;
import com.senatic.siri.formularios.model.VoluntariosAprendicesFormadosCol;
import com.senatic.siri.formularios.repository.VoluntariosAprendicesFormadosColRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class VoluntariosAprendicesFormadosColService implements GenericUseCases<VoluntariosAprendicesFormadosCol, Integer> {

    private final VoluntariosAprendicesFormadosColRepository repository;

    @Override
    public List<VoluntariosAprendicesFormadosCol> handleListAll() {
        return repository.findAll();
    }

    @Override
    public void handleUpdate(VoluntariosAprendicesFormadosCol t) {
        repository.save(t);
    }

    @Override
    public void handleDelete(VoluntariosAprendicesFormadosCol t) {
        repository.delete(t);
    }

    @Override
    public void handleDeleteById(Integer u) {
        repository.deleteById(u);
    }

    @Override
    public Page<VoluntariosAprendicesFormadosCol> handleFindAllPaginateByExample(Example<VoluntariosAprendicesFormadosCol> example,
            Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<VoluntariosAprendicesFormadosCol> handleFindAllByExample(Example<VoluntariosAprendicesFormadosCol> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<VoluntariosAprendicesFormadosCol> handleFindAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Boolean handleAlreadyExist(VoluntariosAprendicesFormadosCol t) {
        return repository.exists(Example.of(t));
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        return repository.existsById(u);
    }

    @Override
    public void handleCreateNewRegister(VoluntariosAprendicesFormadosCol t) {
        repository.save(t);
    }

    @Override
    public void handleCreateNewListOfRegisters(List<VoluntariosAprendicesFormadosCol> list) {
        repository.saveAll(list);
    }
}
