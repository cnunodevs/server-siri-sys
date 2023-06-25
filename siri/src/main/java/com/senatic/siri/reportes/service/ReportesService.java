package com.senatic.siri.reportes.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.senatic.siri.common.GenericUseCases;
import com.senatic.siri.reportes.model.Reporte;
import com.senatic.siri.reportes.repository.ReportesRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ReportesService implements GenericUseCases<Reporte, Integer> {

    private final ReportesRepository repository;

    @Override
    public List<Reporte> handleListAll() {
        return repository.findAll();
    }

    @Override
    public void handleUpdate(Reporte t) {
        repository.save(t);
    }

    @Override
    public void handleDelete(Reporte t) {
        repository.delete(t);
    }

    @Override
    public void handleDeleteById(Integer u) {
        repository.deleteById(u);
    }

    @Override
    public Page<Reporte> handleFindAllPaginateByExample(Example<Reporte> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public List<Reporte> handleFindAllByExample(Example<Reporte> example) {
        return repository.findAll(example);
    }

    @Override
    public Page<Reporte> handleFindAllPaginate(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Boolean handleAlreadyExist(Reporte t) {
        return repository.exists(Example.of(t));
    }

    @Override
    public Boolean handleAlreadyExistById(Integer u) {
        return repository.existsById(u);
    }

    @Override
    public void handleCreateNewRegister(Reporte t) {
        repository.save(t);
    }

    @Override
    public void handleCreateNewListOfRegisters(List<Reporte> list) {
        repository.saveAll(list);
    }
}
