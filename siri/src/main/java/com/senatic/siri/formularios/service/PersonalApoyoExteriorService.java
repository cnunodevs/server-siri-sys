package com.senatic.siri.formularios.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.common.GenericUseCases;
import com.senatic.siri.formularios.model.PersonalApoyoExterior;
import com.senatic.siri.formularios.repository.PersonalApoyoExteriorRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonalApoyoExteriorService implements GenericUseCases<PersonalApoyoExterior, Integer> {

    private final PersonalApoyoExteriorRepository repository;

    @Override
    public List<PersonalApoyoExterior> handleListAll() {
        return repository.findAll();
    }

    @Override
    public void handleUpdate(PersonalApoyoExterior t) {
        repository.save(t);
    }

    @Override
    public void handleDelete(PersonalApoyoExterior t) {
        repository.delete(t);
    }

    @Override
    public void handleDeleteById(Integer u) {
        repository.deleteById(u);
    }

    @Override
    public Page<PersonalApoyoExterior> handleFindAllPaginateByExample(Example<PersonalApoyoExterior> example,
            Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<PersonalApoyoExterior> handleFindAllByExample(Example<PersonalApoyoExterior> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<PersonalApoyoExterior> handleFindAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Boolean handleAlreadyExist(PersonalApoyoExterior t) {
        return repository.exists(Example.of(t));
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        return repository.existsById(u);
    }

    @Override
    public void handleCreateNewRegister(PersonalApoyoExterior t) {
        repository.save(t);
    }

    @Override
    public void handleCreateNewListOfRegisters(List<PersonalApoyoExterior> list) {
        repository.saveAll(list);
    }
}
