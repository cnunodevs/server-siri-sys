package com.senatic.siri.formularios.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.common.GenericUseCases;
import com.senatic.siri.formularios.model.ExpertosInternacionales;
import com.senatic.siri.formularios.repository.ExpertosInternacionalesRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ExpertosInternacionalesService implements GenericUseCases<ExpertosInternacionales, Integer> {

    private final ExpertosInternacionalesRepository repository;

    @Override
    public List<ExpertosInternacionales> handleListAll() {
        return repository.findAll();
    }

    @Override
    public void handleUpdate(ExpertosInternacionales t) {
        repository.save(t);
    }

    @Override
    public void handleDelete(ExpertosInternacionales t) {
        repository.delete(t);
    }

    @Override
    public void handleDeleteById(Integer u) {
        repository.deleteById(u);
    }

    @Override
    public Page<ExpertosInternacionales> handleFindAllPaginateByExample(Example<ExpertosInternacionales> example,
            Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<ExpertosInternacionales> handleFindAllByExample(Example<ExpertosInternacionales> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<ExpertosInternacionales> handleFindAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Boolean handleAlreadyExist(ExpertosInternacionales t) {
        return repository.exists(Example.of(t));
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        return repository.existsById(u);
    }

    @Override
    public void handleCreateNewRegister(ExpertosInternacionales t) {
        repository.save(t);
    }

    @Override
    public void handleCreateNewListOfRegisters(List<ExpertosInternacionales> list) {
        repository.saveAll(list);
    }
}